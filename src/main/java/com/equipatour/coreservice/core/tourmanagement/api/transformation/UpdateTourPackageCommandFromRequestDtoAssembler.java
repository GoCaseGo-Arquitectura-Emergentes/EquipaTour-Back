package com.equipatour.coreservice.core.tourmanagement.api.transformation;

import com.equipatour.coreservice.core.tourmanagement.domain.commands.UpdateTourPackageCommand;
import com.equipatour.coreservice.core.tourmanagement.resources.requests.TourPackageRequestDto;

public class UpdateTourPackageCommandFromRequestDtoAssembler {
    public static UpdateTourPackageCommand toCommandFromDto(Long id, TourPackageRequestDto requestDto) {
        return new UpdateTourPackageCommand(id, requestDto);
    }
}
