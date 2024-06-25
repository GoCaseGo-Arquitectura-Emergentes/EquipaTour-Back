package com.equipatour.coreservice.assets.domain.repositories;

import com.equipatour.coreservice.assets.domain.model.VibrationSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VibrationSensorRepository extends JpaRepository<VibrationSensor, Long> {
    List<VibrationSensor> findAllByDriverId(Long driverId);
}
