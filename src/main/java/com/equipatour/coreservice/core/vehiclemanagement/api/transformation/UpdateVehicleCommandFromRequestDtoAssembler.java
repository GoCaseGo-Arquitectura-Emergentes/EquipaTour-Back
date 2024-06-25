package com.equipatour.coreservice.core.vehiclemanagement.api.transformation;

import com.equipatour.coreservice.core.vehiclemanagement.domain.commands.UpdateVehicleCommand;
import com.equipatour.coreservice.core.vehiclemanagement.resources.requests.VehicleRequestDto;

public class UpdateVehicleCommandFromRequestDtoAssembler {
    public static UpdateVehicleCommand toCommandFromDto(Long id, VehicleRequestDto requestDto) {
        return new UpdateVehicleCommand(id, requestDto);
    }
}
