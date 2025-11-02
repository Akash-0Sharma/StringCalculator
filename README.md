# String Calculator TDD Kata

A Test-Driven Development (TDD) implementation of the String Calculator Kata in Java using JUnit 5 and Maven.

## 📋 Project Overview

This project implements a simple String Calculator that can add numbers from a string input. It follows strict TDD principles, with each feature developed through the Red-Green-Refactor cycle.

## ✨ Features Implemented

- ✅ Empty string returns `0`
- ✅ Single number returns the number itself
- ✅ Two numbers (comma-separated) returns their sum
- ✅ Any amount of numbers returns the sum
- ✅ Newline delimiters (mixed with commas) are supported
- ✅ Custom single-character delimiters (e.g., `//;\n1;2`)
- ✅ Custom delimiters of any length in brackets (e.g., `//[***]\n1***2***3`)
- ✅ Multiple custom delimiters (e.g., `//[*][%]\n1*2%3`)
- ✅ Negative numbers throw exception with all negatives listed
- ✅ Numbers greater than 1000 are ignored

## 🚀 How to Run

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Run Tests
```bash
mvn test
```

### Build Project
```bash
mvn clean install
```

## 📝 Test Examples

```java
// Empty string
calculator.add("") → 0

// Single number
calculator.add("1") → 1

// Multiple numbers
calculator.add("1,2,3") → 6

// Newlines as delimiters
calculator.add("1\n2,3") → 6

// Custom delimiter
calculator.add("//;\n1;2") → 3

// Custom delimiter in brackets
calculator.add("//[***]\n1***2***3") → 6

// Multiple custom delimiters
calculator.add("//[*][%]\n1*2%3") → 6

// Negative numbers (throws exception)
calculator.add("1,-2,3") → IllegalArgumentException: "negatives not allowed: -2"

// Ignore numbers > 1000
calculator.add("2,1001") → 2
```

## 🔄 Commit History - TDD Implementation

This project follows Test-Driven Development (TDD) principles with clear commit messages documenting each step of the Red-Green-Refactor cycle.

### Initial Setup
- **Commit 1:** `test: empty string returns 0` - Added first failing test for the simplest case

### Basic Functionality
- **Commit 2:** `feat: return 0 for empty input` - Implemented minimal code to pass empty string test
- **Commit 3:** `test: single and two numbers` - Added tests for single number and two comma-separated numbers
- **Commit 4:** `feat: support single and two comma-separated numbers` - Implemented parsing and summing for comma-separated numbers
- **Commit 5:** `test: any amount of numbers` - Added test to verify support for unlimited numbers

### Delimiter Support
- **Commit 6:** `test: support newlines mixed with commas` - Added tests for newline delimiter support
- **Commit 7:** `feat: support newline delimiters with commas` - Implemented newline delimiter parsing
- **Commit 8:** `test: support custom delimiter format` - Added tests for custom single-character delimiters (e.g., `//;\n1;2`)
- **Commit 9:** `feat: implement custom delimiter parsing` - Implemented custom delimiter header parsing

### Error Handling
- **Commit 10:** `test: throw exception for negative numbers` - Added tests for negative number validation
- **Commit 11:** `feat: throw exception for negative numbers with all negatives listed` - Implemented negative number detection and exception throwing with all negatives in message

### Number Filtering
- **Commit 12:** `test: ignore numbers greater than 1000` - Added tests for ignoring large numbers
- **Commit 13:** `feat: ignore numbers greater than 1000` - Implemented filtering for numbers > 1000

### Advanced Delimiter Features
- **Commit 14:** `test: support delimiters of any length in brackets` - Added tests for bracket-delimited delimiters (e.g., `//[***]\n1***2***3`)
- **Commit 15:** `feat: extract and escape delimiters from brackets` - Implemented bracket extraction and regex escaping for single bracket-delimited delimiters
- **Commit 16:** `test: support multiple delimiters in brackets` - Added tests for multiple bracket-delimited delimiters (e.g., `//[*][%]\n1*2%3`)
- **Commit 17:** `feat: support multiple delimiters in brackets` - Implemented parsing and combining multiple bracket-delimited delimiters

### Total Commits: 17

## 🎯 TDD Approach

This implementation strictly follows TDD principles:

1. **Red:** Write a failing test
2. **Green:** Write minimal code to make it pass
3. **Refactor:** Improve code quality while keeping tests green
4. **Repeat:** Each feature follows this cycle

Each commit represents one step in the TDD cycle, showing the evolution of the code through incremental improvements.

## 📁 Project Structure

```
.
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── incubyte/
    │               └── StringCalculator.java
    └── test/
        └── java/
            └── com/
                └── incubyte/
                    └── StringCalculatorTest.java
```

## 🛠️ Technology Stack

- **Java 17**
- **Maven** - Build tool and dependency management
- **JUnit 5** - Testing framework
- **JUnit Jupiter** - JUnit 5 API

## 📚 Requirements

This kata implements all the requirements from the String Calculator TDD Kata:

1. ✅ Create a simple String calculator with method `int add(String numbers)`
2. ✅ Handle empty string (returns 0)
3. ✅ Handle single number (returns the number)
4. ✅ Handle two numbers (returns sum)
5. ✅ Handle unknown amount of numbers
6. ✅ Allow newlines between numbers
7. ✅ Support different delimiters with format `//[delimiter]\n`
8. ✅ Throw exception for negative numbers with all negatives listed
9. ✅ Ignore numbers bigger than 1000
10. ✅ Support delimiters of any length: `//[delimiter]\n`
11. ✅ Allow multiple delimiters: `//[delim1][delim2]\n`


