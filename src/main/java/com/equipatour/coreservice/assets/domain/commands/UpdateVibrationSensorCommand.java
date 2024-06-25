package com.equipatour.coreservice.assets.domain.commands;

import com.equipatour.coreservice.assets.resources.requests.UpdateVibrationSensorRequestDto;

public record UpdateVibrationSensorCommand(Long assetId, boolean hasPossibleCrashWarning) {
}
