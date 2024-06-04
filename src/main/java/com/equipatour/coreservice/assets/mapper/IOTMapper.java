package com.equipatour.coreservice.assets.mapper;

import com.equipatour.coreservice.assets.domain.model.WeightBalance;
import com.equipatour.coreservice.assets.resources.summaries.WeightBalanceSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOTMapper {

    @Mappings({
            @Mapping(target = "actualWeight", source = "entity.weight"),
    })
    WeightBalanceSummaryDto balanceToSummaryDto(WeightBalance entity);
    List<WeightBalanceSummaryDto> balanceToSummaryDtos(List<WeightBalance> entities);
}
