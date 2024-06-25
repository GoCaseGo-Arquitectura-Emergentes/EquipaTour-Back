package com.equipatour.coreservice.assets.api.REST;

import com.equipatour.coreservice.assets.api.transformation.CreateVibrationSensorCommandFromRequestDtoAssembler;
import com.equipatour.coreservice.assets.domain.commands.UpdateVibrationSensorCommand;
import com.equipatour.coreservice.assets.domain.model.VibrationSensor;
import com.equipatour.coreservice.assets.domain.queries.GetAllVibrationSensorsByDriverIdQuery;
import com.equipatour.coreservice.assets.domain.queries.GetVibrationSensorQuery;
import com.equipatour.coreservice.assets.domain.services.VibrationSensorCommandService;
import com.equipatour.coreservice.assets.mapper.IOTMapper;
import com.equipatour.coreservice.assets.resources.requests.CreateVibrationSensorRequestDto;
import com.equipatour.coreservice.assets.resources.requests.UpdateVibrationSensorRequestDto;
import com.equipatour.coreservice.assets.resources.summaries.VibrationSensorSummaryDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vibration-sensors")
@Tag(name="Vibration Sensors Controller")
public class VibrationSensorController {
    private final VibrationSensorCommandService vibrationSensorCommandService;
    private final IOTMapper iotMapper;
    @Autowired
    public VibrationSensorController(VibrationSensorCommandService vibrationSensorCommandService, IOTMapper iotMapper) {
        this.vibrationSensorCommandService = vibrationSensorCommandService;
        this.iotMapper = iotMapper;
    }
    @PostMapping("create-vibration-sensor")
    public VibrationSensorSummaryDto createVibrationSensor(@RequestBody @Valid CreateVibrationSensorRequestDto requestDto) {
        VibrationSensor vibrationSensor = vibrationSensorCommandService.handle(CreateVibrationSensorCommandFromRequestDtoAssembler.toCommandFromDto(requestDto));
        return iotMapper.vibrationSensorToSummaryDto(vibrationSensor);
    }
    @PutMapping("/update-vibration-sensor/{vibrationSensorId}")
    public VibrationSensorSummaryDto updateVibrationSensor(@PathVariable("vibrationSensorId") Long vibrationSensorId,
                                                           @RequestBody @Valid UpdateVibrationSensorRequestDto requestDto) {
        VibrationSensor vibrationSensor = vibrationSensorCommandService.handle(new UpdateVibrationSensorCommand(vibrationSensorId, requestDto.hasPossibleCrashWarning));
        return iotMapper.vibrationSensorToSummaryDto(vibrationSensor);
    }
    @GetMapping("get-all-vibration-sensors/{driverId}")
    public List<VibrationSensorSummaryDto> getAllVibrationSensors(@PathVariable("driverId") Long driverId) {
        List<VibrationSensor> vibrationSensors = vibrationSensorCommandService.handle(new GetAllVibrationSensorsByDriverIdQuery(driverId));
        return iotMapper.vibrationSensorsToSummaryDto(vibrationSensors);
    }
    @GetMapping("consult-possible-crash-warning/{vibrationSensorId}")
    public boolean alterVibrationSensor(@PathVariable("vibrationSensorId") Long vibrationSensorId) {
        return vibrationSensorCommandService.handle(new GetVibrationSensorQuery(vibrationSensorId));
    }
}
