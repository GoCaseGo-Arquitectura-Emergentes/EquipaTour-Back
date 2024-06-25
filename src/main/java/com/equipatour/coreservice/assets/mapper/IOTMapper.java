package com.equipatour.coreservice.assets.mapper;

import com.equipatour.coreservice.assets.domain.model.VibrationSensor;
import com.equipatour.coreservice.assets.domain.model.WeightBalance;
import com.equipatour.coreservice.assets.resources.summaries.VibrationSensorSummaryDto;
import com.equipatour.coreservice.assets.resources.summaries.WeightBalanceSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOTMapper {

    @Mappings({
            @Mapping(target = "actualWeight", source = "entity.weight"),
    })
    WeightBalanceSummaryDto balanceToSummaryDto(WeightBalance entity);
    List<WeightBalanceSummaryDto> balanceToSummaryDtos(List<WeightBalance> entities);

    @Mappings({
            @Mapping(target = "id", source = "vibrationSensor.id"),
            @Mapping(target = "driverId", source = "vibrationSensor.driver.id"),
            @Mapping(target = "serie", source = "vibrationSensor.serie"),
            @Mapping(target = "hasPossibleCrashWarning", source = "vibrationSensor.hasPossibleCrashWarning"),
    })
    VibrationSensorSummaryDto vibrationSensorToSummaryDto(VibrationSensor vibrationSensor);
    List<VibrationSensorSummaryDto> vibrationSensorsToSummaryDto(List<VibrationSensor> vibrationSensors);
}
