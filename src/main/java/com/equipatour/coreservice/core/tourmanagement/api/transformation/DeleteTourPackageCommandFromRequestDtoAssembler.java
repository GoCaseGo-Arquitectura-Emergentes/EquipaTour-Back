package com.equipatour.coreservice.core.tourmanagement.api.transformation;


import com.equipatour.coreservice.core.tourmanagement.domain.commands.DeleteTourPackageCommand;
import com.equipatour.coreservice.core.tourmanagement.resources.requests.TourPackageRequestDto;

public class DeleteTourPackageCommandFromRequestDtoAssembler {
    public static DeleteTourPackageCommand toCommandFromDto(Long id) {
        return new DeleteTourPackageCommand(id);
    }
}
