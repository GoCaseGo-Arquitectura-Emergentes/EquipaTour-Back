package com.equipatour.coreservice.core.tourmanagement.mapper;

import com.equipatour.coreservice.core.tourmanagement.domain.model.TourPackage;
import com.equipatour.coreservice.core.tourmanagement.resources.summaries.TourPackageSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TourMapper {

    @Mappings({
            @Mapping(target = "availableSlots", source = "entity.availableSlots"),
            @Mapping(target = "packageName", source = "entity.packageName"),
            @Mapping(target = "guideName", source = "entity.guideName")

    })
    TourPackageSummaryDto tourPackageToSummaryDto(TourPackage entity);

    List<TourPackageSummaryDto> tourPackageToSummaryDtos(List<TourPackage> entities);
}
