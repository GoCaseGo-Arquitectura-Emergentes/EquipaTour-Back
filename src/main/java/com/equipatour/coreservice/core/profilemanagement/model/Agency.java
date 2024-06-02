package com.equipatour.coreservice.core.profilemanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author Erikc-Cortez
 * @version 01-06-2024
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "ETB_AGENCY")
public class Agency implements Serializable {

    @Id
    @Column(name = "ETAG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ETAG_SORE")
    private String socialReason;

    @Column(name = "ETAG_RUC")
    private String ruc;

    @Column(name = "ETAG_ALIA")
    private String alias;

    @Column(name = "ETAG_LOCA")
    private String location;

    @Column(name = "ETAG_PHOT")
    private String photoUrl;

    // @OneToMany(mappedBy = "agency")
    // private List<User> users;
}
