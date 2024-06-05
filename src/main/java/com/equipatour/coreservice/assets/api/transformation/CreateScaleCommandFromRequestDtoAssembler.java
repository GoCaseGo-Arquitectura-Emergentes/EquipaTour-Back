package com.equipatour.coreservice.assets.api.transformation;

import com.equipatour.coreservice.assets.domain.commands.CreateScaleCommand;
import com.equipatour.coreservice.assets.resources.requests.CreateScaleRequestDto;

public class CreateScaleCommandFromRequestDtoAssembler {
    public static CreateScaleCommand toCommandFromDto(CreateScaleRequestDto requestDto) {
        return new CreateScaleCommand(requestDto);
    }
}
