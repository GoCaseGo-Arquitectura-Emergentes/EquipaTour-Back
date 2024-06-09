package com.equipatour.coreservice.core.tourmanagement.application;

import com.equipatour.coreservice.core.tourmanagement.domain.commands.CreateTourPackageCommand;
import com.equipatour.coreservice.core.tourmanagement.domain.commands.DeleteTourPackageCommand;
import com.equipatour.coreservice.core.tourmanagement.domain.commands.UpdateTourPackageCommand;
import com.equipatour.coreservice.core.tourmanagement.domain.model.TourPackage;
import com.equipatour.coreservice.core.tourmanagement.domain.queries.GetTourPackageByIdQuery;
import com.equipatour.coreservice.core.tourmanagement.domain.repositories.TourPackageRepository;
import com.equipatour.coreservice.core.tourmanagement.domain.services.TourPackageCommandService;
import com.equipatour.coreservice.shared.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPackageCommandServiceImpl implements TourPackageCommandService {

    private final TourPackageRepository tourPackageRepository;

    public TourPackageCommandServiceImpl(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    @Override
    public List<TourPackage> handle() {
        return tourPackageRepository.findAll(Sort.by(Sort.Order.asc("createdDate")));
    }

    @Override
    public TourPackage handle(UpdateTourPackageCommand command) {
        TourPackage tourPackage = tourPackageRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found with id: " + command.id()));

        tourPackage.setGuideName(command.requestDto().getGuideName());
        tourPackage.setAvailableSlots(command.requestDto().getAvailableSlots());
        tourPackageRepository.save(tourPackage);
        return tourPackage;
    }

    @Override
    public TourPackage handle(GetTourPackageByIdQuery command) {
        return tourPackageRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found with id: " + command.id()));
    }

    @Override
    public TourPackage handle(CreateTourPackageCommand commandFromDto) {
        TourPackage tourPackage = new TourPackage(commandFromDto.requestDto());
        tourPackageRepository.save(tourPackage);
        return tourPackage;
    }

    @Override
    public TourPackage handle(DeleteTourPackageCommand command) {
        TourPackage tourPackage = tourPackageRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found with id: " + command.id()));
        tourPackageRepository.deleteById(tourPackage.getId());
        return tourPackage;
    }
}
