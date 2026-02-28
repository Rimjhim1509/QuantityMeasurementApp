## UC14: Temperature Category with Selective Arithmetic Support

**Date:** February 27, 2026  

---

## Overview
Introduced **Temperature** category (Celsius, Fahrenheit, Kelvin) with selective operation support.

Unlike other categories, temperature supports equality and conversion but restricts arithmetic operations.

---

## Implementation Details

### 1. TemperatureUnit Enum
- Units:
  - `CELSIUS`
  - `FAHRENHEIT`
  - `KELVIN`
- Non-linear conversion formulas implemented

### 2. Interface Refactor
- Updated `IMeasurable` with default methods
- Introduced `SupportsArithmetic` functional interface

### 3. Operation Validation
- Arithmetic operations validated at runtime
- Throws `UnsupportedOperationException` when not allowed

### 4. Architectural Impact
- No breaking changes to existing categories
- Maintained type safety and backward compatibility

---
