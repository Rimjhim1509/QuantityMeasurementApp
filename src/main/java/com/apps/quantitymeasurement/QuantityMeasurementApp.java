package com.apps.quantitymeasurement;

import java.util.function.BooleanSupplier;

public class QuantityMeasurementApp {

    // Inner class
    public static class Feet {

        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {

            // Reflexive
            if (this == obj)
                return true;

            // Null + Type check
            if (obj == null || getClass() != obj.getClass())
                return false;

            Feet other = (Feet) obj;

            // Floating comparison
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }
    public static boolean compareFeet(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
    }

    public static boolean compareInches1(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals(i2);
    }


    // Main method
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Are Equal? " + f1.equals(f2));
        System.out.println("Inches Equal: " + compareInches1(1.0, 1.0));
    }


	public static BooleanSupplier compareInches(double d, double e) {
		// TODO Auto-generated method stub
		return null;
	}
}