package com.apps.quantitymeasurement;

public class Length{
	private final double value ;
	private final LengthUnit unit;
	public enum LengthUnit{
		INCHES(1.0),
		FEET(12.0),
		CENTIMETERS(0.393701),
		YARDS(36.0);
		private final double factor ;
		private LengthUnit(double factor){
			this.factor = factor;
		}
		public double getFactor() {
			return factor ;
		}
		
	}
	private static final double EPSILON = 0.0001;
	public Length(double value , LengthUnit unit) {
		
		if(unit==null) throw new IllegalArgumentException("Unit cannot be null");
		if(!Double.isFinite(value)) throw new IllegalArgumentException("Invalid numeric value");
		this.value=value;
		this.unit = unit ;
	}
	private double toBase() {
		return value*unit.getFactor();
	}
	public Length convertTo(LengthUnit targetUnit) {
		if(targetUnit == null ) 
			throw new IllegalArgumentException("Target unit cannot be null");
		double baseValue = toBase();
		double converted = baseValue / targetUnit.getFactor();
		return new Length(converted ,targetUnit);
		
	}
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Length) ) return false;
		
		Length other = (Length) obj;
		return Math.abs(this.toBase() - other.toBase())< EPSILON ;
	}
	public int hashCode() {
		return Double.hashCode(toBase());
	}
	public String toString() {
        return String.format("%.2f %s", value, unit);
    }
	public static void main(String[] args) {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        System.out.println(l1.equals(l2)); // true

        Length l3 = new Length(36, LengthUnit.INCHES);
        System.out.println(l3.convertTo(LengthUnit.YARDS)); // 1.00 YARDS

        Length l4 = new Length(100, LengthUnit.CENTIMETERS);
        System.out.println(l4.equals(new Length(39.3701, LengthUnit.INCHES)));
    }
}