package com.equipatour.coreservice.assets.resources.requests;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UpdateVibrationSensorRequestDto {
    public boolean hasPossibleCrashWarning;
}
