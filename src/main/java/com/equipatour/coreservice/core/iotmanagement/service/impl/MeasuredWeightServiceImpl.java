package com.equipatour.coreservice.core.iotmanagement.service.impl;

import com.equipatour.coreservice.core.iotmanagement.beans.MeasuredWeightBean;
import com.equipatour.coreservice.core.iotmanagement.dao.MeasuredWeightDAO;
import com.equipatour.coreservice.core.iotmanagement.model.MeasuredWeight;
import com.equipatour.coreservice.core.iotmanagement.service.MeasuredWeightService;
import com.equipatour.coreservice.shared.base.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
public class MeasuredWeightServiceImpl extends BaseService<MeasuredWeight, MeasuredWeightBean> implements MeasuredWeightService {

    @Autowired
    private MeasuredWeightDAO measuredWeightRepository;

    @Override
    public MeasuredWeightBean toBean(MeasuredWeight model, Class<MeasuredWeightBean> modelClass) {
        MeasuredWeightBean bean = new MeasuredWeightBean();
        BeanUtils.copyProperties(model, bean);
        // bean.setAgency(model.getAgency().getId());
        return bean;
    }

    @Override
    public MeasuredWeightBean getById(Long measuredWeightId) {
        Optional<MeasuredWeight> measuredWeightOptional = measuredWeightRepository.findById(measuredWeightId);

        if(measuredWeightOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("MeasuredWeight %s not found", measuredWeightId));
        }

        return toBean(measuredWeightOptional.get(), MeasuredWeightBean.class);
    }

    @Override
    public void createMeasuredWeight(MeasuredWeightBean measuredWeightBean) {
        measuredWeightRepository.save(toModel(measuredWeightBean, MeasuredWeight.class));
    }

    @Override
    public void updateMeasuredWeight(Long measuredWeightId, MeasuredWeightBean measuredWeightBean) {
        Optional<MeasuredWeight> measuredWeightOptional = measuredWeightRepository.findById(measuredWeightId);

        if(measuredWeightOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("MeasuredWeight %s not found", measuredWeightId));
        }

        measuredWeightRepository.save(toModel(measuredWeightBean, MeasuredWeight.class));
    }

    @Override
    public void deleteMeasuredWeight(Long measuredWeightId) {
        Optional<MeasuredWeight> measuredWeightOptional = measuredWeightRepository.findById(measuredWeightId);

        if(measuredWeightOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("MeasuredWeight %s not found", measuredWeightId));
        }

        measuredWeightRepository.delete(measuredWeightOptional.get());
    }

    @Override
    public void registerBalanceData(Long balanceId, Float weight) {
        log.info("********** balanceId: {}, weight: {} **********", balanceId, weight);
    }
}
