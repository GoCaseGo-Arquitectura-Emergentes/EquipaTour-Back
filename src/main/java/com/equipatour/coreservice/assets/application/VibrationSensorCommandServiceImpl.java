package com.equipatour.coreservice.assets.application;

import com.equipatour.coreservice.assets.domain.commands.CreateVibrationSensorCommand;
import com.equipatour.coreservice.assets.domain.commands.UpdateVibrationSensorCommand;
import com.equipatour.coreservice.assets.domain.model.VibrationSensor;
import com.equipatour.coreservice.assets.domain.queries.GetAllVibrationSensorsByDriverIdQuery;
import com.equipatour.coreservice.assets.domain.queries.GetVibrationSensorQuery;
import com.equipatour.coreservice.assets.domain.repositories.VibrationSensorRepository;
import com.equipatour.coreservice.assets.domain.services.VibrationSensorCommandService;
import com.equipatour.coreservice.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.equipatour.coreservice.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VibrationSensorCommandServiceImpl  implements VibrationSensorCommandService {
    private final VibrationSensorRepository vibrationSensorRepository;
    private final UserRepository userRepository;
    public VibrationSensorCommandServiceImpl(VibrationSensorRepository vibrationSensorRepository, UserRepository userRepository) {
        this.vibrationSensorRepository = vibrationSensorRepository;
        this.userRepository = userRepository;
    }
    @Override
    public VibrationSensor handle(CreateVibrationSensorCommand command) {
        VibrationSensor vibrationSensor = new VibrationSensor(command.requestDto());
        vibrationSensor.setDriver(userRepository.findById(command.requestDto().getDriverId())
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found")));
        vibrationSensorRepository.save(vibrationSensor);
        return vibrationSensor;
    }
    @Override
    public VibrationSensor handle(UpdateVibrationSensorCommand sensorCommand) {
        VibrationSensor existingVibrationSensor = vibrationSensorRepository.findById(sensorCommand.assetId())
                .orElseThrow(() -> new ResourceNotFoundException("Vibration sensor not found"));
        existingVibrationSensor.setPossibleCrashWarning(sensorCommand.hasPossibleCrashWarning());
        vibrationSensorRepository.save(existingVibrationSensor);
        return existingVibrationSensor;
    }

    @Override
    public List<VibrationSensor> handle(GetAllVibrationSensorsByDriverIdQuery getAllVibrationSensorsByDriverIdQuery) {
        return vibrationSensorRepository.findAllByDriverId(getAllVibrationSensorsByDriverIdQuery.driverId());
    }

    @Override
    public boolean handle(GetVibrationSensorQuery getVibrationSensorQuery) {
        VibrationSensor existingVibrationSensor = vibrationSensorRepository.findById(getVibrationSensorQuery.id())
                .orElseThrow(() -> new ResourceNotFoundException("Vibration sensor not found"));
        return existingVibrationSensor.isHasPossibleCrashWarning();
    }
}
