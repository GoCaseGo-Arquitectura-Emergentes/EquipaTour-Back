package com.equipatour.coreservice.core.tourmanagement.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Tour Package (Request)")
public class TourPackageRequestDto {

    @Schema(description = "Id del paquete")
    private Long id;

    @Schema(description = "Nombre del guía")
    private String guideName;

    @Schema(description = "Cupos disponibles")
    private Long availableSlots;

}
