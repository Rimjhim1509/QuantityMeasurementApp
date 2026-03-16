package com.quantitymeasurement.controller;

import com.quantitymeasurement.entity.QuantityDTO;
import com.quantitymeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service){
        this.service = service;
    }
    //

    public void performAdd(QuantityDTO q1,QuantityDTO q2){
        System.out.println(service.add(q1,q2).getValue());
    }

    public void performCompare(QuantityDTO q1,QuantityDTO q2){
        System.out.println(service.compare(q1,q2));
    }

    public void performConvert(QuantityDTO q,String target){
        System.out.println(service.convert(q,target).getValue());
    }
    public void performSubtract(QuantityDTO q1, QuantityDTO q2) {
    	System.out.println(service.subtract(q1, q2).getValue());
    }
}