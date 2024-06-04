package com.equipatour.coreservice.assets.api.transformation;

import com.equipatour.coreservice.assets.domain.commands.UpdateWeightCommand;
import com.equipatour.coreservice.assets.resources.requests.WeightBalanceRequestDto;

public class UpdateWeightBalanceCommandFromRequestDtoAssembler {
    public static UpdateWeightCommand toCommandFromDto(Long id, WeightBalanceRequestDto requestDto) {
        return new UpdateWeightCommand(id, requestDto);
    }
}
