package com.equipatour.coreservice.core.vehiclemanagement.domain.repositories;

import com.equipatour.coreservice.core.vehiclemanagement.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
