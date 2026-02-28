# UC2: Feet and Inches Measurement Equality

**Date:** February 20, 2026  

---

## Overview
This use case extends the equality comparison logic to support both `Feet` and `Inches` measurements.  
Each unit maintains its own value-based equality implementation.

---

## Implementation Details

### 1. Inches Class
- Separate `Inches` class introduced  
- Immutable `double value`  
- Constructor-based initialization  
- No setters to preserve immutability  

### 2. Equality Logic
- Proper `equals()` override in both `Feet` and `Inches`
- Uses `Double.compare()` for accurate floating-point comparison
- Includes:
  - Null check  
  - Type check  
  - Value comparison  

### 3. Helper Methods
- Introduced static helper methods  
- Reduced dependency on `main()`  
- Improved readability and reusability  

### 4. Testing
- Test cases added for:
  - `Feet` equality  
  - `Inches` equality  
- Validated equality contract behavior  

---

## Design Principles Applied
- Equality Contract  
- Type Safety  
- DRY Awareness (violation identified for future refactoring)  
- Clean Test Design  

---

## Outcome
Both `Feet` and `Inches` now support reliable value-based equality comparison,  
while maintaining separation of concerns and improved test clarity.
