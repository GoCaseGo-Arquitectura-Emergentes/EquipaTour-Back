package com.equipatour.coreservice.core.iotmanagement.model;

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
@Table(name = "ETB_MEASURE_WEIGHT")
public class MeasuredWeight implements Serializable {

    @Id
    @Column(name = "ETMW_BAID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balanceId;

    @Column(name = "ETMW_WEIG")
    private Float weight;
}
