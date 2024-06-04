package com.equipatour.coreservice.assets.application;

import com.equipatour.coreservice.assets.domain.commands.UpdateWeightCommand;
import com.equipatour.coreservice.assets.domain.model.WeightBalance;
import com.equipatour.coreservice.assets.domain.queries.GetWeightBalanceByIdQuery;
import com.equipatour.coreservice.assets.domain.repositories.WeightBalanceRepository;
import com.equipatour.coreservice.assets.domain.services.WeightBalanceCommandService;
import com.equipatour.coreservice.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WeightBalanceCommandServiceImpl implements WeightBalanceCommandService {

    private final WeightBalanceRepository weightBalanceRepository;

    public WeightBalanceCommandServiceImpl(WeightBalanceRepository weightBalanceRepository) {
        this.weightBalanceRepository = weightBalanceRepository;
    }

    @Override
    public WeightBalance handle(UpdateWeightCommand command) {
        WeightBalance weightBalance = weightBalanceRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("WeightBalance not found with id: " + command.id()));

        weightBalance.setWeight(command.requestDto().getWeight());
        weightBalanceRepository.save(weightBalance);
        return weightBalance;
    }

    @Override
    public WeightBalance handle(GetWeightBalanceByIdQuery command) {
        WeightBalance weightBalance = weightBalanceRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("WeightBalance not found with id: " + command.id()));
        return weightBalance;
    }
}
