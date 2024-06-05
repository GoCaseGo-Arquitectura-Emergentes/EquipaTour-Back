package com.equipatour.coreservice.assets.domain.services;


import com.equipatour.coreservice.assets.domain.commands.CreateScaleCommand;
import com.equipatour.coreservice.assets.domain.commands.UpdateWeightCommand;
import com.equipatour.coreservice.assets.domain.model.WeightBalance;
import com.equipatour.coreservice.assets.domain.queries.GetWeightBalanceByIdQuery;

public interface WeightBalanceCommandService {
    WeightBalance handle(UpdateWeightCommand command);
    WeightBalance handle(GetWeightBalanceByIdQuery command);

    WeightBalance handle(CreateScaleCommand commandFromDto);
}
