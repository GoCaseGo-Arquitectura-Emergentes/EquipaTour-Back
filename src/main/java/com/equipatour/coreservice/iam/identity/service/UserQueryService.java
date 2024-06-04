package com.equipatour.coreservice.iam.identity.service;

import com.equipatour.coreservice.iam.identity.domain.model.User;
import com.equipatour.coreservice.iam.identity.domain.queries.GetUserByIdQuery;

public interface UserQueryService {

    User handle(GetUserByIdQuery query);
}
