package com.quantitymeasurement.service;

import com.quantitymeasurement.entity.QuantityDTO;
import com.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.quantitymeasurement.exception.QuantityMeasurementException;
import com.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.quantitymeasurement.units.LengthUnit;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository){
        this.repository = repository;
    }

    // This method working is to compare value of two unit
    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2){

        if(q1 == null || q2 == null){
            throw new QuantityMeasurementException("Quantity cannot be null");
        }

        try{

            LengthUnit u1 = LengthUnit.valueOf(q1.getUnit());
            LengthUnit u2 = LengthUnit.valueOf(q2.getUnit());

            double base1 = u1.toBase(q1.getValue());
            double base2 = u2.toBase(q2.getValue());

            boolean result = base1 == base2;

            repository.save(new QuantityMeasurementEntity("COMPARE",
                    String.valueOf(result)));

            return result;

        }catch(IllegalArgumentException e){

            throw new QuantityMeasurementException("Invalid unit provided");
        }
    }

    //
    public QuantityDTO convert(QuantityDTO source,String targetUnit){

        LengthUnit src = LengthUnit.valueOf(source.getUnit());
        LengthUnit target = LengthUnit.valueOf(targetUnit);

        double base = src.toBase(source.getValue());

        double result = target.fromBase(base);

        repository.save(new QuantityMeasurementEntity("CONVERT",
                String.valueOf(result)));

        return new QuantityDTO(result,targetUnit);
    }

    
    //Method to adding two unit values
    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2){

        if(q1 == null || q2 == null){
            throw new QuantityMeasurementException("Quantity cannot be null");
        }

        try{

            LengthUnit u1 = LengthUnit.valueOf(q1.getUnit());
            LengthUnit u2 = LengthUnit.valueOf(q2.getUnit());

            double base = u1.toBase(q1.getValue()) + u2.toBase(q2.getValue());

            double result = u1.fromBase(base);

            repository.save(new QuantityMeasurementEntity("ADD",
                    String.valueOf(result)));

            return new QuantityDTO(result,q1.getUnit());

        }catch(IllegalArgumentException e){

            throw new QuantityMeasurementException("Invalid unit provided");
        }
    }

    //Method for subtract unit 
    public QuantityDTO subtract(QuantityDTO q1,QuantityDTO q2){
    	if(q1 == null || q2 == null){
            throw new QuantityMeasurementException("Quantity cannot be null");
        }
    	try {
			
    		LengthUnit u1 = LengthUnit.valueOf(q1.getUnit());
            LengthUnit u2 = LengthUnit.valueOf(q2.getUnit());

            double base = u1.toBase(q1.getValue()) - u2.toBase(q2.getValue());

            double result = u1.fromBase(base);

            repository.save(new QuantityMeasurementEntity("SUBTRACT",
                    String.valueOf(result)));

            return new QuantityDTO(result,q1.getUnit());
		} catch (Exception e) {
			throw new QuantityMeasurementException("Invalid unit provided");
		}

        
    }

    //Method for dividing units 
    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2){

        if(q2.getValue() == 0){
            throw new QuantityMeasurementException("Division by zero is not allowed");
        }

        double result = q1.getValue() / q2.getValue();

        repository.save(new QuantityMeasurementEntity("DIVIDE",
                String.valueOf(result)));

        return result;
    }
}