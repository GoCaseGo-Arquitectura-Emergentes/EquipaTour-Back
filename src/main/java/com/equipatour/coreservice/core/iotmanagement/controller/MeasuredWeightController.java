package com.equipatour.coreservice.core.iotmanagement.controller;

import com.equipatour.coreservice.core.iotmanagement.beans.MeasuredWeightBean;
import com.equipatour.coreservice.core.iotmanagement.service.impl.MeasuredWeightServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import com.google.gson.Gson;


@Log4j2
@Api
@RestController
@RequestMapping("/service/measured-weight")
@Tag(name = "MeasuredWeightController", description = "Measured Weight EndPoint")
public class MeasuredWeightController {

    @Autowired
    private MeasuredWeightServiceImpl measuredWeightService;

    // CRUD
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long measuredWeightId) {
        try {
            return new ResponseEntity<>(measuredWeightService.getById(measuredWeightId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createMeasuredWeight(@RequestBody MeasuredWeightBean measuredWeightBean) {
        try {
            measuredWeightService.createMeasuredWeight(measuredWeightBean);
            return new ResponseEntity<>("created", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMeasuredWeight(@PathVariable("id") Long measuredWeightId, @RequestBody MeasuredWeightBean measuredWeightBean) {
        try {
            measuredWeightService.updateMeasuredWeight(measuredWeightId, measuredWeightBean);
            return new ResponseEntity<>("updated", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMeasuredWeight(@PathVariable("id") Long measuredWeightId) {
        try {
            measuredWeightService.deleteMeasuredWeight(measuredWeightId);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // CORE

    @DeleteMapping("/{balanceId}/{weight}")
    public ResponseEntity<?> registerBalanceData(@PathVariable("balanceId") Long balanceId, @PathVariable("weight") Float weight) {
        try {
            measuredWeightService.registerBalanceData(balanceId, weight);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
