package com.equipatour.coreservice.assets.api.transformation;

import com.equipatour.coreservice.assets.domain.commands.CreateVibrationSensorCommand;
import com.equipatour.coreservice.assets.resources.requests.CreateVibrationSensorRequestDto;

public class CreateVibrationSensorCommandFromRequestDtoAssembler {
    public static CreateVibrationSensorCommand toCommandFromDto(CreateVibrationSensorRequestDto requestDto) {
        return new CreateVibrationSensorCommand(requestDto);
    }
}
