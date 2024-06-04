package com.equipatour.coreservice.iam.identity.service;

import com.equipatour.coreservice.iam.identity.domain.commands.RegisterUserAgencyCommand;
import com.equipatour.coreservice.iam.identity.domain.model.User;

public interface UserCommandService {
    User handle(RegisterUserAgencyCommand registerUserCommand);
}
