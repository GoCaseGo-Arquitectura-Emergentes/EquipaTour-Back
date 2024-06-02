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
@Table(name = "ETB_USER")
public class User implements Serializable {

    @Id
    @Column(name = "ETUS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ETUS_NAME")
    private String name;

    @Column(name = "ETUS_PASS")
    private String password;

    @OneToOne(mappedBy = "owner")
    private Account account;

    // @ManyToOne()
    // @JoinColumn(name = "AGT_ID", referencedColumnName = "AGT_ID")
    // private Agency agency;
}
