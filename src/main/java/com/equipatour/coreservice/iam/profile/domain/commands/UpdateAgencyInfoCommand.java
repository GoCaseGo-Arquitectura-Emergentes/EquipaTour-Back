package com.equipatour.coreservice.iam.profile.domain.commands;

import com.equipatour.coreservice.iam.profile.resources.requests.AgencyRequestDto;

public record UpdateAgencyInfoCommand (AgencyRequestDto agencyRequestDto) {
}
