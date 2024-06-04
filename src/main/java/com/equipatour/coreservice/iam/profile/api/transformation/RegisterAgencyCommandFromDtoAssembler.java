package com.equipatour.coreservice.iam.profile.api.transformation;

import com.equipatour.coreservice.iam.profile.domain.commands.CreateAgencyCommand;
import com.equipatour.coreservice.iam.profile.resources.requests.AgencyRequestDto;

public class RegisterAgencyCommandFromDtoAssembler {
    public static CreateAgencyCommand toCommandFromDto(Long uid, AgencyRequestDto requestDto){
        return new CreateAgencyCommand(uid, requestDto);
    }
}
