package com.equipatour.coreservice.iam.profile.service;

import com.equipatour.coreservice.iam.profile.domain.commands.CreateAgencyCommand;
import com.equipatour.coreservice.iam.profile.domain.commands.UpdateAgencyPhotoCommand;
import com.equipatour.coreservice.iam.profile.domain.model.Agency;

public interface AgencyCommandService {
    Agency handle(UpdateAgencyPhotoCommand command);
    Agency handle(CreateAgencyCommand command);
}
