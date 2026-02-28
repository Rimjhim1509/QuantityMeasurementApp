# UC4: Extended Unit Support

**Date:** February 22, 2026  

---

## Overview
This use case extends the `QuantityLength` system to support additional units:  
**Yards** and **Centimeters**.

The enhancement validates the extensibility of the enum-based design without modifying core equality logic.

---

## Implementation Details

### 1. LengthUnit Enhancements
- Added:
  - `YARDS`
  - `CENTIMETERS`
- Defined appropriate conversion factors to base unit (feet)
- Maintained centralized unit configuration inside the enum

### 2. Conversion Logic
- Base-unit normalization continues using **feet**
- No changes required in equality logic
- Conversion factors enable seamless multi-unit comparison

### 3. Multi-Unit Equality Validation
- Verified comparisons such as:
  - Yards ↔ Feet
  - Centimeters ↔ Inches
  - Mixed cross-unit scenarios
- Ensured accuracy through base-unit comparison

### 4. Additional Test Cases
- Added cross-unit validation tests
- Confirmed backward compatibility with existing units
- Verified equality contract remains intact

