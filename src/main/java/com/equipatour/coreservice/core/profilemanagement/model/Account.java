package com.equipatour.coreservice.core.profilemanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Erikc-Cortez
 * @version 01-06-2024
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "ETB_ACCOUNT")
public class Account implements Serializable {

    @Id
    @Column(name = "ETAC_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ETAC_NAME")
    private String name;

    @OneToOne()
    @JoinColumn(name = "ETUS_ID", referencedColumnName = "ETUS_ID")
    private User owner;
}
