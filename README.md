# UC5: Explicit Unit-to-Unit Conversion

**Date:** February 24, 2026  

---

## Overview
Introduced an explicit conversion API to allow direct transformation between supported length units.

---

## Implementation Details

### 1. Conversion API
- `convert(value, sourceUnit, targetUnit)` method
- Enables direct unit-to-unit conversion
- Centralized and reusable conversion logic

### 2. Validation
- Checks for:
  - `NaN`
  - Infinite values
  - Null units
- Ensures safe and predictable API behavior

### 3. Precision Handling
- Floating-point precision managed using epsilon comparison
- Reduces rounding-related inconsistencies

### 4. Overloaded Demonstrations
- Added overloaded methods to demonstrate flexible usage
- Improved API usability

