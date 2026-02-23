package com.apps.quantitymeasurement;
import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // Precision tolerance for double comparison
    private static final double EPSILON = 0.0001;

    // Base unit = INCHES
    public enum LengthUnit {

        INCHES(1.0),             // Base unit
        FEET(12.0),              // 1 ft = 12 in
        YARDS(36.0),             // 1 yd = 36 in
        CENTIMETERS(0.393701);   // 1 cm = 0.393701 in

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double toBase(double value) {
            return value * conversionFactor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double toBaseUnit() {
        return unit.toBase(value);
    }

    // Comparison logic
    private boolean isEqual(Length other) {
        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length other = (Length) o;
        return isEqual(other);
    }

    @Override
    public int hashCode() {
        // Round to maintain consistency with EPSILON logic
        long rounded = Math.round(toBaseUnit() / EPSILON);
        return Objects.hash(rounded);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}