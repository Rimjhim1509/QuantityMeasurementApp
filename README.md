
# UC11: Volume Category Integration

**Date:** February 27, 2026  

---

## Overview
Introduced a third category — **Volume** — to validate the scalability of the generic `Quantity<U>` architecture.

Only a new enum was required, demonstrating true extensibility.

---

## Implementation Details

### 1. VolumeUnit Enum
- Units introduced:
  - `LITRE`
  - `MILLILITRE`
  - `GALLON`
- Base unit: `LITRE`

### 2. Reuse of Generic Logic
- Equality handled by generic class
- Conversion handled via interface contract
- Addition supported automatically

### 3. Test Coverage
- Comprehensive unit tests for:
  - Equality
  - Conversion
  - Addition

---

