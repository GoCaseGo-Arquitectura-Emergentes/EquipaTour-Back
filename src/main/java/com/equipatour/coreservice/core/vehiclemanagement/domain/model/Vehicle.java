package com.equipatour.coreservice.core.vehiclemanagement.domain.model;

import com.equipatour.coreservice.core.tourmanagement.resources.requests.CreateTourPackageRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.equipatour.coreservice.core.vehiclemanagement.resources.requests.CreateVehicleRequestDto;
import com.equipatour.coreservice.shared.domain.model.VehicleStatus;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.equipatour.coreservice.shared.domain.model.AuditModel;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "vehicle")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE vehicle SET _deleted = 1 WHERE id = ?")

public class Vehicle extends AuditModel {

    @Column(name = "vehicleState")
    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleState;

    @Column(name = "vehicleModel")
    private String vehicleModel;

    @Column(name = "vehicleBrand")
    private String vehicleBrand;

    @Column(name = "vehicleWeight")
    private Long vehicleWeight;

    @Column(name = "vehicleDriver")
    private String vehicleDriver;

    @Column(name = "vehicleSeats")
    private Long vehicleSeats;

    public Vehicle(CreateVehicleRequestDto createVehicleRequestDto) {
        this.vehicleState = createVehicleRequestDto.getVehicleState();
        this.vehicleModel = createVehicleRequestDto.getVehicleModel();
        this.vehicleBrand = createVehicleRequestDto.getVehicleBrand();
        this.vehicleWeight = createVehicleRequestDto.getVehicleWeight();
        this.vehicleDriver = createVehicleRequestDto.getVehicleDriver();
        this.vehicleSeats = createVehicleRequestDto.getVehicleSeats();
    }
}
