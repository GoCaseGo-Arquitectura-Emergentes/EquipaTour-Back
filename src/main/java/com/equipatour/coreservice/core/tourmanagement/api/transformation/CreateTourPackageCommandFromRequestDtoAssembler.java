package com.equipatour.coreservice.core.tourmanagement.api.transformation;

import com.equipatour.coreservice.core.tourmanagement.domain.commands.CreateTourPackageCommand;
import com.equipatour.coreservice.core.tourmanagement.resources.requests.CreateTourPackageRequestDto;

public class CreateTourPackageCommandFromRequestDtoAssembler {
    public static CreateTourPackageCommand toCommandFromDto(CreateTourPackageRequestDto requestDto) {
        return new CreateTourPackageCommand(requestDto);
    }
}
