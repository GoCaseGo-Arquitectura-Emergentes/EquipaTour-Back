package com.equipatour.coreservice.iam.identity.api.transformation;

import com.equipatour.coreservice.iam.identity.domain.commands.RegisterUserAgencyCommand;
import com.equipatour.coreservice.iam.identity.resources.requests.UserRequestDto;

public class RegisterUserAgencyCommandFromRequestDtoAssembler {
    public static RegisterUserAgencyCommand toCommandFromDto(UserRequestDto requestDto){
        return new RegisterUserAgencyCommand(requestDto);
    }
}
