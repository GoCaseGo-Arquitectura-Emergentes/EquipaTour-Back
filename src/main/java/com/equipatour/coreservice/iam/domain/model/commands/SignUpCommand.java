package com.equipatour.coreservice.iam.domain.model.commands;

import com.equipatour.coreservice.iam.domain.model.entities.Role;
import com.equipatour.coreservice.iam.domain.model.valueobjects.Roles;

import java.util.List;

public record SignUpCommand(String username, String password, Roles rol) {
}
