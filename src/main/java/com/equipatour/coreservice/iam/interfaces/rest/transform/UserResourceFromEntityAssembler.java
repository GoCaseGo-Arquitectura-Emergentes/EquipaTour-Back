package com.equipatour.coreservice.iam.interfaces.rest.transform;

import com.equipatour.coreservice.iam.domain.model.aggregates.User;
import com.equipatour.coreservice.iam.interfaces.rest.resources.CreateUserResource;
import com.equipatour.coreservice.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(user.getId(), user.getUsername(), user.getRole().getName().name());
    }
}
