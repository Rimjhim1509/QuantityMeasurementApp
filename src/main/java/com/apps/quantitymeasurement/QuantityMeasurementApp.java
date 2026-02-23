package com.apps.quantitymeasurement;

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

    // Main method
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Are Equal? " + f1.equals(f2));
    }
}