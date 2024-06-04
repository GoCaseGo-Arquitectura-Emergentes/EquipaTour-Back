package com.equipatour.coreservice.iam.identity.domain.commands;

import com.equipatour.coreservice.iam.identity.resources.requests.UserRequestDto;

public record RegisterUserAgencyCommand(UserRequestDto userRequestDto) {
}
