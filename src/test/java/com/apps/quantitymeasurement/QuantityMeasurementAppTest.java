package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;

public	class QuantityMeasurementAppTest {

	    @Test
	    void testEquality_SameValue() {
	        Feet f1 = new QuantityMeasurementApp.Feet(1.0);
	        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(1.0);

	        assertTrue(f1.equals(f2));
	    }

	    @Test
	    void testEquality_DifferentValue() {
	        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
	        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);

	        assertFalse(f1.equals(f2));
	    }

	    @Test
	    void testEquality_NullComparison() {
	        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

	        assertFalse(f1.equals(null));
	    }

	    @Test
	    void testEquality_SameReference() {
	        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

	        assertTrue(f1.equals(f1));
	    }
	}

