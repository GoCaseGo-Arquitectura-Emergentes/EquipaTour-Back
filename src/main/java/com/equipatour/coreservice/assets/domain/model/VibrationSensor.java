package com.equipatour.coreservice.assets.domain.model;

import com.equipatour.coreservice.assets.resources.requests.CreateVibrationSensorRequestDto;
import com.equipatour.coreservice.iam.domain.model.aggregates.User;
import com.equipatour.coreservice.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "vibration_sensors")
public class VibrationSensor extends AuditModel {
    @Column(name = "is_vibrating")
    private boolean isVibrating;

    @Column(name = "serie")
    private String serie;

    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;

    @Column(name = "has_possible_crash_warning")
    private boolean hasPossibleCrashWarning;

    public VibrationSensor(CreateVibrationSensorRequestDto createSensorRequestDto) {
        this.number = createSensorRequestDto.getNumber();
        this.serie = createSensorRequestDto.getSerie();
    }

    public void setPossibleCrashWarning(boolean hasPossibleCrashWarning) {
        this.hasPossibleCrashWarning = hasPossibleCrashWarning;
    }
}

