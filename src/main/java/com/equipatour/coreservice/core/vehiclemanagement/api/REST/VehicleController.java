package com.equipatour.coreservice.core.vehiclemanagement.api.REST;

import com.equipatour.coreservice.core.vehiclemanagement.api.transformation.CreateVehicleCommandFromRequestDtoAssembler;
import com.equipatour.coreservice.core.vehiclemanagement.api.transformation.DeleteVehicleCommandFromRequestDtoAssembler;
import com.equipatour.coreservice.core.vehiclemanagement.api.transformation.UpdateVehicleCommandFromRequestDtoAssembler;
import com.equipatour.coreservice.core.vehiclemanagement.domain.commands.UpdateVehicleCommand;
import com.equipatour.coreservice.core.vehiclemanagement.domain.model.Vehicle;
import com.equipatour.coreservice.core.vehiclemanagement.domain.queries.GetVehicleByIdQuery;
import com.equipatour.coreservice.core.vehiclemanagement.domain.services.VehicleCommandService;
import com.equipatour.coreservice.core.vehiclemanagement.mapper.VehicleMapper;
import com.equipatour.coreservice.core.vehiclemanagement.resources.requests.CreateVehicleRequestDto;
import com.equipatour.coreservice.core.vehiclemanagement.resources.requests.VehicleRequestDto;
import com.equipatour.coreservice.core.vehiclemanagement.resources.summaries.VehicleSummaryDto;
import com.equipatour.coreservice.shared.constants.HeaderConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import static com.equipatour.coreservice.shared.messages.ConfigurationMessages.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
@Tag(name="Vehicle Controller")
public class VehicleController {

    private final VehicleCommandService vehicleCommandService;

    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleController(VehicleCommandService vehicleCommandService,
                             VehicleMapper vehicleMapper){
        this.vehicleCommandService = vehicleCommandService;
        this.vehicleMapper = vehicleMapper;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los vehiculos.")
    public List<VehicleSummaryDto> getVehicles(){
        List<Vehicle> vehicles = vehicleCommandService.handle();
        return vehicleMapper.vehicleToSummaryDtos(vehicles);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtner Vehiculo", description = "Permite ver un vehiculo especifico.")
    public VehicleSummaryDto getVehicle(@Parameter @PathVariable("id") Long id) {
        Vehicle vehicle = vehicleCommandService.handle(new GetVehicleByIdQuery(id));
        return vehicleMapper.vehicleToSummaryDto(vehicle);
    }

    @PostMapping("create-vehicle")
    @Operation(summary = "Crear vehiculo", description = "Permite subir los datos de un vehiculo.")
    public VehicleSummaryDto createVehicle(@RequestBody @Valid CreateVehicleRequestDto requestDto,
                                           HttpServletResponse response) {
        Vehicle vehicle = vehicleCommandService.handle(CreateVehicleCommandFromRequestDtoAssembler.toCommandFromDto(requestDto));
        response.setHeader(HeaderConstants.MESSAGES, VEHICLE_CREATED);
        return vehicleMapper.vehicleToSummaryDto(vehicle);
    }

    @PutMapping("/update-vehicle/{id}")
    @Operation(summary = "Actualizar vehiculo", description = "Permite actualizar los datos del vehiculo")
    public VehicleSummaryDto updateVehicle(@Parameter @PathVariable("id") Long id,
                                           @RequestBody @Valid VehicleRequestDto requestDto,
                                           HttpServletResponse response) {
        Vehicle vehicle = vehicleCommandService.handle(UpdateVehicleCommandFromRequestDtoAssembler.toCommandFromDto(id, requestDto));
        response.setHeader(HeaderConstants.MESSAGES, VEHICLE_MODIFIED);
        return vehicleMapper.vehicleToSummaryDto(vehicle);
    }

    @DeleteMapping("/delete-vehicle/{id}")
    @Operation(summary = "Eliminar vehiculo", description = "Permite eliminar un vehiculo.")
    public VehicleSummaryDto deleteVehicle(@Parameter @PathVariable("id") Long id,
                                           HttpServletResponse response) {
        Vehicle vehicle = vehicleCommandService.handle(DeleteVehicleCommandFromRequestDtoAssembler.toCommandFromDto(id));
        response.setHeader(HeaderConstants.MESSAGES, VEHICLE_DELETE);
        return vehicleMapper.vehicleToSummaryDto(vehicle);
    }



}
