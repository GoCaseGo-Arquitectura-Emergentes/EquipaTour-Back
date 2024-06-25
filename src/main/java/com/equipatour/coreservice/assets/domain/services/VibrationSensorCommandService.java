package com.equipatour.coreservice.assets.domain.services;

import com.equipatour.coreservice.assets.domain.commands.CreateVibrationSensorCommand;
import com.equipatour.coreservice.assets.domain.commands.UpdateVibrationSensorCommand;
import com.equipatour.coreservice.assets.domain.model.VibrationSensor;
import com.equipatour.coreservice.assets.domain.queries.GetAllVibrationSensorsByDriverIdQuery;
import com.equipatour.coreservice.assets.domain.queries.GetVibrationSensorQuery;

import java.util.List;

public interface VibrationSensorCommandService {
    VibrationSensor handle(CreateVibrationSensorCommand command);

    VibrationSensor handle(UpdateVibrationSensorCommand commandFromDto);

    List<VibrationSensor> handle(GetAllVibrationSensorsByDriverIdQuery getAllVibrationSensorsByDriverIdQuery);

    boolean handle(GetVibrationSensorQuery getVibrationSensorQuery);
}
