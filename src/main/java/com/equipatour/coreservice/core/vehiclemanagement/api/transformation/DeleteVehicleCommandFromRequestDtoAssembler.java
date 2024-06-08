package com.equipatour.coreservice.core.vehiclemanagement.api.transformation;

import com.equipatour.coreservice.core.vehiclemanagement.domain.commands.DeleteVehicleCommand;

public class DeleteVehicleCommandFromRequestDtoAssembler {
    public static DeleteVehicleCommand toCommandFromDto(Long id) {
        return new DeleteVehicleCommand(id);
    }
}
