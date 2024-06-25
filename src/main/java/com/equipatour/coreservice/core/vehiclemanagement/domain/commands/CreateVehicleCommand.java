package com.equipatour.coreservice.core.vehiclemanagement.domain.commands;

import com.equipatour.coreservice.core.vehiclemanagement.resources.requests.CreateVehicleRequestDto;

public record CreateVehicleCommand(CreateVehicleRequestDto requestDto) {
}
