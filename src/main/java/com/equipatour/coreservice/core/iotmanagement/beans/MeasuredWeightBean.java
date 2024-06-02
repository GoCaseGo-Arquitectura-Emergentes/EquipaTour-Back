package com.equipatour.coreservice.core.iotmanagement.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MeasuredWeightBean implements Serializable {

    @Expose
    private Long balanceId;

    @Expose
    private Float weight;
}
