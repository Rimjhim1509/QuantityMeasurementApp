package com.apps.quantitymeasurement;
import java.util.Objects;

public class QuantityMeasurementApp {

    // Generic method to demonstrate Length equality
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {

        boolean result = length1.equals(length2);

        System.out.println("Comparing: "
                + length1 + " AND " + length2
                + " -> Equal? " + result);

        return result;
    }

    // Static method to create Length objects and compare
    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);

        return demonstrateLengthEquality(length1, length2);
    }

    public static void main(String[] args) {

        // Feet and Inches
        demonstrateLengthComparison(
                1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES);

        // Yards and Inches
        demonstrateLengthComparison(
                1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        // Centimeters and Inches
        demonstrateLengthComparison(
                100.0, Length.LengthUnit.CENTIMETERS,
                39.3701, Length.LengthUnit.INCHES);

        // Feet and Yards
        demonstrateLengthComparison(
                3.0, Length.LengthUnit.FEET,
                1.0, Length.LengthUnit.YARDS);

        // Centimeters and Feet
        demonstrateLengthComparison(
                30.48, Length.LengthUnit.CENTIMETERS,
                1.0, Length.LengthUnit.FEET);
    }
}