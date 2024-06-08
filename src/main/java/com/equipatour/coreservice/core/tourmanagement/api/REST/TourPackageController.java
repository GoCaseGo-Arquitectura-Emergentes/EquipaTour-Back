package com.equipatour.coreservice.core.tourmanagement.api.REST;

import com.equipatour.coreservice.core.tourmanagement.api.transformation.CreateTourPackageCommandFromRequestDtoAssembler;
import com.equipatour.coreservice.core.tourmanagement.api.transformation.DeleteTourPackageCommandFromRequestDtoAssembler;
import com.equipatour.coreservice.core.tourmanagement.api.transformation.UpdateTourPackageCommandFromRequestDtoAssembler;
import com.equipatour.coreservice.core.tourmanagement.domain.model.TourPackage;
import com.equipatour.coreservice.core.tourmanagement.domain.queries.GetTourPackageByIdQuery;
import com.equipatour.coreservice.core.tourmanagement.domain.services.TourPackageCommandService;
import com.equipatour.coreservice.core.tourmanagement.mapper.TourMapper;
import com.equipatour.coreservice.core.tourmanagement.resources.requests.CreateTourPackageRequestDto;
import com.equipatour.coreservice.core.tourmanagement.resources.requests.TourPackageRequestDto;
import com.equipatour.coreservice.core.tourmanagement.resources.summaries.TourPackageSummaryDto;
import com.equipatour.coreservice.shared.constants.HeaderConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import java.util.List;

import static com.equipatour.coreservice.shared.messages.ConfigurationMessages.*;

@RestController
@RequestMapping("/api/v1/tour-package")
@Tag(name="Tour Package Controller")
public class TourPackageController {

    private final TourPackageCommandService tourPackageCommandService;
    private final TourMapper tourMapper;

    @Autowired
    public TourPackageController(TourPackageCommandService tourPackageCommandService,
                                 TourMapper tourMapper) {
        this.tourPackageCommandService = tourPackageCommandService;
        this.tourMapper = tourMapper;
    }

    @GetMapping
    @Operation(summary = "Obtener Todos los Paquete Turístico")
    public List<TourPackageSummaryDto> getTours() {
        List<TourPackage> tourPackages = tourPackageCommandService.handle();
        return tourMapper.tourPackageToSummaryDtos(tourPackages);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Paquete Turístico", description = "Permite ver paquete turístico.")
    public TourPackageSummaryDto getTourPackage(@Parameter @PathVariable("id") Long id) {
        TourPackage tourPackage = tourPackageCommandService.handle(new GetTourPackageByIdQuery(id));
        return tourMapper.tourPackageToSummaryDto(tourPackage);
    }

    @PostMapping("create-tourPackage")
    @Operation(summary = "Crear Paquete Turístico", description = "Permite crear un paquete turístico.")
    public TourPackageSummaryDto createTourPackage(@RequestBody @Valid CreateTourPackageRequestDto requestDto,
                                                 HttpServletResponse response) {
        TourPackage tourPackage = tourPackageCommandService.handle(CreateTourPackageCommandFromRequestDtoAssembler.toCommandFromDto(requestDto));
        response.setHeader(HeaderConstants.MESSAGES, TOUR_PACKAGE_CREATED);
        return tourMapper.tourPackageToSummaryDto(tourPackage);
    }

    @PutMapping("/update-tour-package/{id}")
    @Operation(summary = "Actualizar Paquete Turístico", description = "Permite actualizar el paquete turístico.")
    public TourPackageSummaryDto updateTourPackage(@Parameter @PathVariable("id") Long id,
                                              @RequestBody @Valid TourPackageRequestDto requestDto,
                                              HttpServletResponse response) {
        TourPackage tourPackage =
                tourPackageCommandService.handle(UpdateTourPackageCommandFromRequestDtoAssembler.toCommandFromDto(id, requestDto));
        response.setHeader(HeaderConstants.MESSAGES, TOUR_PACKAGE_MODIFIED);
        return tourMapper.tourPackageToSummaryDto(tourPackage);
    }

    @DeleteMapping("/delete-tour-package/{id}")
    @Operation(summary = "Eliminar Paquete Turístico", description = "Permite eliminar el paquete turístico.")
    public TourPackageSummaryDto deleteTourPackage(@Parameter @PathVariable("id") Long id,
                                                   HttpServletResponse response) {
        TourPackage tourPackage = tourPackageCommandService.handle(DeleteTourPackageCommandFromRequestDtoAssembler.toCommandFromDto(id));
        response.setHeader(HeaderConstants.MESSAGES, TOUR_PACKAGE_DELETE);
        return tourMapper.tourPackageToSummaryDto(tourPackage);
    }


}
