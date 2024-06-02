package com.equipatour.coreservice.core.iotmanagement.service;

import com.equipatour.coreservice.core.iotmanagement.beans.MeasuredWeightBean;

public interface MeasuredWeightService {

    void registerBalanceData(Long balanceId, Float weight);

    MeasuredWeightBean getById(Long measuredWeightId);

    void createMeasuredWeight(MeasuredWeightBean measuredWeightBean);

    void updateMeasuredWeight(Long measuredWeightId, MeasuredWeightBean measuredWeightBean);

    void deleteMeasuredWeight(Long measuredWeightId);
}
