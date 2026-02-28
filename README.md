## UC12: Subtraction and Division Operations

**Date:** February 27, 2026  

---

## Overview
Extended arithmetic support to include subtraction and division for all supported categories.

---

## Implementation Details

### 1. Subtraction
- `subtract()` method introduced
- Returns new immutable `Quantity<U>`
- Supports implicit and explicit target unit

### 2. Division
- `divide()` method returns `double`
- Produces dimensionless scalar ratio

### 3. Validation
- Division-by-zero checks
- Cross-category arithmetic prevention

---
