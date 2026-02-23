package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class QuantityMeasurementAppTest {

    // ---------- SAME UNIT TESTS ----------

    @Test
    void testEquality_YardToYard_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(l1, l2);
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(2.0, Length.LengthUnit.YARDS);
        assertNotEquals(l1, l2);
    }

    @Test
    void testEquality_CmToCm_SameValue() {
        Length l1 = new Length(5.0, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(5.0, Length.LengthUnit.CENTIMETERS);
        assertEquals(l1, l2);
    }

    // ---------- CROSS UNIT EQUALITY ----------

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);
        assertEquals(l1, l2);
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        Length l1 = new Length(3.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(l1, l2);
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(36.0, Length.LengthUnit.INCHES);
        assertEquals(l1, l2);
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {
        Length l1 = new Length(36.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(l1, l2);
    }

    @Test
    void testEquality_CentimeterToInches_EquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(0.393701, Length.LengthUnit.INCHES);
        assertEquals(l1, l2);
    }

    // ---------- CROSS UNIT INEQUALITY ----------

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);
        assertNotEquals(l1, l2);
    }

    @Test
    void testEquality_CentimeterToFeet_NonEquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertNotEquals(l1, l2);
    }

    // ---------- TRANSITIVE PROPERTY ----------

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        Length a = new Length(1.0, Length.LengthUnit.YARDS);
        Length b = new Length(3.0, Length.LengthUnit.FEET);
        Length c = new Length(36.0, Length.LengthUnit.INCHES);

        assertEquals(a, b);
        assertEquals(b, c);
        assertEquals(a, c);
    }

    // ---------- REFLEXIVE, NULL, SAME REFERENCE ----------

    @Test
    void testEquality_SameReference() {
        Length l = new Length(2.0, Length.LengthUnit.YARDS);
        assertEquals(l, l);
    }

    @Test
    void testEquality_NullComparison() {
        Length l = new Length(2.0, Length.LengthUnit.YARDS);
        assertNotEquals(l, null);
    }

    @Test
    void testEquality_DifferentType() {
        Length l = new Length(2.0, Length.LengthUnit.YARDS);
        assertNotEquals(l, "Not a Length");
    }

    // ---------- COMPLEX SCENARIO ----------

    @Test
    void testEquality_AllUnits_ComplexScenario() {
        Length yard = new Length(2.0, Length.LengthUnit.YARDS);
        Length feet = new Length(6.0, Length.LengthUnit.FEET);
        Length inches = new Length(72.0, Length.LengthUnit.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }

    // ---------- NULL UNIT TEST ----------

    @Test
    void testEquality_NullUnit_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        });
    }
}