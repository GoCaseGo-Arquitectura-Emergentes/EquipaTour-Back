package com.equipatour.coreservice.core.tourmanagement.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Create Tour Package (Request)")
public class CreateTourPackageRequestDto {

        @Schema(description = "Id del paquete")
        private Long id;

        @Schema(description = "Nombre del paquete")
        private String packageName;

        @Schema(description = "Cupos disponibles")
        private Long availableSlots;

        @Schema(description = "Nombre del guía")
        private String guideName;

}
