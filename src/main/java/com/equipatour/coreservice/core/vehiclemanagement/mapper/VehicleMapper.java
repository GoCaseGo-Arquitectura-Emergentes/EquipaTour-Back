package com.equipatour.coreservice.core.vehiclemanagement.mapper;

import com.equipatour.coreservice.core.vehiclemanagement.domain.model.Vehicle;
import com.equipatour.coreservice.core.vehiclemanagement.resources.summaries.VehicleSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mappings({
            @Mapping(target = "vehicleState", source = "entity.vehicleState"),
            @Mapping(target = "vehicleModel", source = "entity.vehicleModel"),
            @Mapping(target = "vehicleBrand", source = "entity.vehicleBrand"),
            @Mapping(target = "vehicleWeight", source = "entity.vehicleWeight"),
            @Mapping(target = "vehicleDriver", source = "entity.vehicleDriver"),
            @Mapping(target = "vehicleSeats", source = "entity.vehicleSeats"),
            @Mapping(target = "vehicleAgency", source = "entity.vehicleAgency")

    })
    VehicleSummaryDto vehicleToSummaryDto(Vehicle entity);

    List<VehicleSummaryDto> vehicleToSummaryDtos(List<Vehicle> entities);
}
