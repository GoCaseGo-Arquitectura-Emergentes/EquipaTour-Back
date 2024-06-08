package com.equipatour.coreservice.iam.interfaces.rest.resources;

import com.equipatour.coreservice.iam.domain.model.valueobjects.Roles;

public record CreateUserResource(String username, String password, Roles role) {
}
