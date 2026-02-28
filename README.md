# UC10: Generic Quantity with IMeasurable

**Date:** February 27, 2026  

---

## Overview
Refactored the system into a single generic `Quantity<U>` class using an interface-driven architecture.

---

## Implementation Details

### 1. IMeasurable Interface
- Defines contract for measurable units
- Enables polymorphic conversion logic

### 2. Generic Quantity<U extends IMeasurable>
- Unified implementation for all categories
- Eliminated duplicate logic
- Enforced type-safe generics

### 3. Refactoring
- `LengthUnit` and `WeightUnit` implement `IMeasurable`
- Simplified `QuantityMeasurementApp`

---
