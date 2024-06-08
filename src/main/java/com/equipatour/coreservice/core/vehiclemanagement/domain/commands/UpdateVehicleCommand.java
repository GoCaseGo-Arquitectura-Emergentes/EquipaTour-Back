package com.equipatour.coreservice.core.vehiclemanagement.domain.commands;

import com.equipatour.coreservice.core.vehiclemanagement.resources.requests.VehicleRequestDto;

public record UpdateVehicleCommand(Long id, VehicleRequestDto requestDto) {
}
