package com.equipatour.coreservice.iam.domain.services;

import com.equipatour.coreservice.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
