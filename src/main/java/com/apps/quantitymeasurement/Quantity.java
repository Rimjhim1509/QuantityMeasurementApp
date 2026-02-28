package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 1e-6;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // Convert to another unit of same type
    public double convertTo(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    // Add and return in current unit
    public Quantity<U> add(Quantity<U> other) {
        validateSameType(other);

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double totalBase = base1 + base2;
        double result = this.unit.convertFromBaseUnit(totalBase);

        return new Quantity<>(result, this.unit);
    }

    // Add and return in target unit
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validateSameType(other);

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double totalBase = base1 + base2;
        double result = targetUnit.convertFromBaseUnit(totalBase);

        return new Quantity<>(result, targetUnit);
    }

    private void validateSameType(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Quantity<?>)) return false;

        Quantity<?> other = (Quantity<?>) obj;

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }
    @Override
    public int hashCode() {
        double base = unit.convertToBaseUnit(value);
        return Objects.hash(Math.round(base / EPSILON));
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }

    // Demo
    public static void main(String[] args) {

        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Are lengths equal? " + l1.equals(l2));

        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Are weights equal? " + w1.equals(w2));

        System.out.println("10 feet in inches: " +
                new Quantity<>(10.0, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES));

        System.out.println("1 ft + 12 in = " + l1.add(l2));

        System.out.println("1 kg + 1000 g in grams = " +
                w1.add(w2, WeightUnit.GRAM));
    }
}