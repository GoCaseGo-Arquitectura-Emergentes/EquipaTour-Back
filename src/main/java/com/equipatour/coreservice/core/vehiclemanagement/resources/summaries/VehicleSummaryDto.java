package com.equipatour.coreservice.core.vehiclemanagement.resources.summaries;

import com.equipatour.coreservice.shared.domain.model.VehicleStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "Vehicle Package (Summary)")
public class VehicleSummaryDto {

    @Schema(description = "Estado del vehiculo")
    private VehicleStatus vehicleState;

    @Schema(description = "Modelo del vehiculo")
    private String vehicleModel;

    @Schema(description = "Marca del vehiculo")
    private String vehicleBrand;

    @Schema(description = "Peso maximo de equipaje a soportar")
    private Long vehicleWeight;

    @Schema(description = "Nombre del chofer")
    private String vehicleDriver;

    @Schema(description = "Numero de asientos")
    private Long vehicleSeats;
}
