package com.equipatour.coreservice.iam.identity.mapper;

import com.equipatour.coreservice.iam.identity.domain.model.User;
import com.equipatour.coreservice.iam.identity.resources.summaries.UserSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IdentityMapper {

    UserSummaryDto userToSummaryDto(User entity);
}