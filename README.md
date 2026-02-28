# UC1: Feet Measurement Equality

**Date:** February 20, 2026  

---

## 📌 Overview
This use case implements value-based equality comparison for `Feet` measurements.
The comparison is based strictly on the numeric value rather than object reference.

---

### 1️⃣ Feet Inner Class
- Immutable `double value`
- Constructor-based initialization
- No setters (ensures immutability)

### 2️⃣ Equality Logic
- Overridden `equals()` method
- Uses `Double.compare()` for accurate floating-point comparison
- Includes:
  - Null check
  - Type check
  - Value comparison

### 3️⃣ Testing
- Validates equality contract:
  - Reflexive
  - Symmetric
  - Transitive
- Covers positive and negative test cases

---

## 🧠 Design Principles Applied
- **Object-Oriented Design**
- **Encapsulation**
- **Immutability**
- **Unit Testing Best Practices**

---

## ✅ Outcome
Feet objects are now compared based on their measurement value,
ensuring logical correctness instead of reference equality.
