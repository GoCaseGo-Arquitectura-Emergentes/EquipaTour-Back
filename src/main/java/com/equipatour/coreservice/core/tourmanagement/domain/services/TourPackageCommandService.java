package com.equipatour.coreservice.core.tourmanagement.domain.services;


import com.equipatour.coreservice.core.tourmanagement.domain.commands.CreateTourPackageCommand;
import com.equipatour.coreservice.core.tourmanagement.domain.commands.DeleteTourPackageCommand;
import com.equipatour.coreservice.core.tourmanagement.domain.commands.UpdateTourPackageCommand;
import com.equipatour.coreservice.core.tourmanagement.domain.model.TourPackage;
import com.equipatour.coreservice.core.tourmanagement.domain.queries.GetTourPackageByIdQuery;

import java.util.List;

public interface TourPackageCommandService {

    List<TourPackage> handle();

    TourPackage handle(CreateTourPackageCommand commandFromDto);

    TourPackage handle(GetTourPackageByIdQuery command);

    TourPackage handle(UpdateTourPackageCommand command);

    TourPackage handle(DeleteTourPackageCommand command);
}
