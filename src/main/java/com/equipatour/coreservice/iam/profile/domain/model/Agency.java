package com.equipatour.coreservice.iam.profile.domain.model;

//import com.equipatour.coreservice.core.tours.domain.model.TourPackage;
import com.equipatour.coreservice.iam.identity.domain.model.User;
import com.equipatour.coreservice.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

@Getter
@Setter
@With
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agencies")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE agencies SET _deleted = true WHERE id = ?")
public class Agency extends AuditModel {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Size(max = 100)
    @Column(name = "legal_name")
    private String legalName;

    @Column(name = "RUC")
    private Long RUC;

    @Size(max = 240)
    @Column(name = "address")
    private String address;

    @Column(name = "agency_photo_url")
    private String agencyPhotoUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "phone_number")
    private String phoneNumber;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "agency")
//    private Set<TourPackage> tourPackages;


}
