# UC3: Generic Quantity Class (DRY Refactor)

**Date:** February 22, 2026  

---

## Overview
This use case refactors the duplicated `Feet` and `Inches` classes into a single unified `QuantityLength` class.  
The design eliminates redundancy and enables cross-unit comparison through base-unit normalization.

---

## Implementation Details

### 1. LengthUnit Enum
- Introduced `LengthUnit` enum  
- Defines supported units (e.g., FEET, INCHES)  
- Stores conversion factors to base unit  

### 2. Base-Unit Normalization
- Standardized internal representation using **feet** as the base unit  
- All values converted to base unit before comparison  
- Ensures consistent equality across units  

### 3. Cross-Unit Equality & Conversion
- `equals()` compares normalized base values  
- Supports comparisons like:
  - `12 inches == 1 foot`
- Enables future extension for additional units  
nability with reduced duplication.
