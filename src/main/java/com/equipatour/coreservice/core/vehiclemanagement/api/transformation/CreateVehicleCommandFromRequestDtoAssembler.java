package com.equipatour.coreservice.core.vehiclemanagement.api.transformation;

import com.equipatour.coreservice.core.vehiclemanagement.domain.commands.CreateVehicleCommand;
import com.equipatour.coreservice.core.vehiclemanagement.resources.requests.CreateVehicleRequestDto;

public class CreateVehicleCommandFromRequestDtoAssembler {
    public static CreateVehicleCommand toCommandFromDto(CreateVehicleRequestDto requestDto) {
        return new CreateVehicleCommand(requestDto);
    }
}
