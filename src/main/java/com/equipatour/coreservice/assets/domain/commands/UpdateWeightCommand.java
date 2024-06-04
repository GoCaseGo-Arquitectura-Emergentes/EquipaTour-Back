package com.equipatour.coreservice.assets.domain.commands;

import com.equipatour.coreservice.assets.resources.requests.WeightBalanceRequestDto;

public record UpdateWeightCommand(Long id, WeightBalanceRequestDto requestDto) {
}
