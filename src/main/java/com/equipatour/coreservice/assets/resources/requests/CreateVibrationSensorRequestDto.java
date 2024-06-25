package com.equipatour.coreservice.assets.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Create Balance (Request)")
public class CreateVibrationSensorRequestDto {
    @Schema(description = "Número de registro")
    private String number;
    @Schema(description = "Serie")
    private String serie;
    private Long driverId;
}
