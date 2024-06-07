package com.equipatour.coreservice.iam.interfaces.rest.transform;

import com.equipatour.coreservice.iam.domain.model.aggregates.User;
import com.equipatour.coreservice.iam.interfaces.rest.resources.SignInUserResource;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class SignInResourceAssembler {
    public static SignInUserResource toResourceFromEntity(ImmutablePair<User, String> user) {
        return new SignInUserResource(user.getLeft().getId(), user.getRight());
    }
}
