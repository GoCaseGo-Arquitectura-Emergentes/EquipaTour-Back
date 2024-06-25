package com.equipatour.coreservice.core.tourmanagement.domain.model;

import com.equipatour.coreservice.core.tourmanagement.resources.requests.CreateTourPackageRequestDto;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.equipatour.coreservice.shared.domain.model.AuditModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
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
@Table(name = "tour_package")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE tour_package SET _deleted = 1 WHERE id = ?")
public class TourPackage extends AuditModel {

    @Column(name = "packageName")
    private String packageName;

    @Column(name = "availableSlots")
    private Long availableSlots;

    @Column(name = "guideName")
    private String guideName;

    public TourPackage(CreateTourPackageRequestDto createTourPackageRequestDto) {
        this.packageName = createTourPackageRequestDto.getPackageName();
        this.availableSlots = createTourPackageRequestDto.getAvailableSlots();
        this.guideName = createTourPackageRequestDto.getGuideName();
    }
}
