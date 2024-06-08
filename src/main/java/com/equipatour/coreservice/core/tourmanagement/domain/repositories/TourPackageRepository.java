package com.equipatour.coreservice.core.tourmanagement.domain.repositories;

import com.equipatour.coreservice.core.tourmanagement.domain.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourPackageRepository extends JpaRepository<TourPackage, Long> {
}
