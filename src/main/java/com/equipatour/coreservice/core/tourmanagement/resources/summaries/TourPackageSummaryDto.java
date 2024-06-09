package com.equipatour.coreservice.core.tourmanagement.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "Tour Package (Summary)")
public class TourPackageSummaryDto {

    @Schema(description = "Nombre del paquete")
    private String packageName;

    @Schema(description = "Cupos disponibles")
    private Long availableSlots;

    @Schema(description = "Nombre del guía")
    private String guideName;

}
