package com.equipatour.coreservice.core.tourmanagement.domain.commands;


import com.equipatour.coreservice.core.tourmanagement.resources.requests.TourPackageRequestDto;

public record UpdateTourPackageCommand(Long id, TourPackageRequestDto requestDto) {
}
