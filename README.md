# Calculator

## Overview

This project implements a simple yet extensible calculator in Java that supports basic arithmetic operations such as addition, subtraction, multiplication, and division. The calculator is designed to work with `Number` objects and supports both individual operations and chaining of multiple operations.

## Features

- **Basic Operations**: The calculator supports addition, subtraction, multiplication, and division.
- **Extensibility**: The design adheres to the Open/Closed Principle (OCP), allowing new operations to be added with minimal code changes.
- **Operation Chaining**: The calculator supports chaining of operations on a single `Number` object, allowing for fluent and readable method calls.

## Design Decisions

1. **Use of `Number` Type**:
    - The calculator is designed to work with `Number` objects, allowing it to handle different numeric types (e.g., `Integer`, `Double`).
    - All operations convert `Number` objects to `double` for processing. This ensures compatibility across numeric types but might lead to precision loss for very large or very small numbers.

2. **Enum for Operations**:
    - Arithmetic operations (`ADD`, `SUBTRACT`, `MULTIPLY`, `DIVIDE`) are represented using an enum called `Operation`.
    - Each enum constant overrides an abstract `apply` method, which contains the specific logic for that operation.

3. **Chaining of Operations**:
    - The `Calculator` class allows for operations to be chained, starting with an initial `Number` and applying a sequence of operations.
    - This is achieved through the `applyOperation` method, which returns the calculator instance (`this`) to allow for method chaining.

4. **Exceptions Handling**:
    - Division by zero is explicitly checked and handled by throwing an `ArithmeticException`.

## Assumptions

1. **Precision**:
    - All operations are performed using `double` precision. This may introduce floating-point errors, especially with very large or very small numbers.

2. **Initial Value**:
    - The `Calculator` class requires an initial value of type `Number` to start the chain of operations.

3. **Error Handling**:
    - The only error explicitly handled is division by zero. It is assumed that inputs will be valid `Number` objects.

## Usage

### Basic Usage

```java
Calculator calculator = new Calculator();
Number result = calculator.calculate(10, 5, Operation.ADD);
System.out.println("Addition Result: " + result);  // Output: 15.0
```

### Method chaining
```java
Calculator calculator = new Calculator(10);
Number finalResult = calculator
                        .applyOperation(5, Calculator.Operation.ADD)
                        .applyOperation(2, Calculator.Operation.MULTIPLY)
                        .getResult();
System.out.println("Final Result: " + finalResult);  // Output: 30.0
```
