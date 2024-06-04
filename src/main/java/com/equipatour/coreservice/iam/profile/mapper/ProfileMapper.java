package com.equipatour.coreservice.iam.profile.mapper;

import com.equipatour.coreservice.iam.profile.domain.model.Agency;
import com.equipatour.coreservice.iam.profile.resources.summaries.AgencySummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "legalName", source = "entity.legalName"),
            @Mapping(target = "agencyPhotoUrl", source = "entity.agencyPhotoUrl"),
            @Mapping(target = "phoneNumber", source = "entity.phoneNumber"),
            @Mapping(target = "email", source = "entity.user.email"),
    })
    AgencySummaryDto agencyToSummaryDto(Agency entity);
    List<AgencySummaryDto> agencyToSummaryDtos(List<Agency> entities);



}
