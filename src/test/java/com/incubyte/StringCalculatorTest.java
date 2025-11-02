package com.incubyte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
	@Test
	void emptyStringReturnsZero() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("");
		assertEquals(0, result);
	}

	@Test
	void singleNumberReturnsValue() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1");
		assertEquals(1, result);
	}

	@Test
	void twoNumbersCommaDelimitedReturnsSum() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1,2");
		assertEquals(3, result);
	}

	@Test
	void anyAmountOfNumbersReturnsSum() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1,2,3,4");
		assertEquals(10, result);
	}

	@Test
	void newlinesAndCommasAreValidDelimiters() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1\n2,3");
		assertEquals(6, result);
	}

	@Test
	void multipleNewlinesAlsoWork() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("4\n5\n6");
		assertEquals(15, result);
	}

	@Test
	void customSingleCharDelimiterWorks() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("//;\n1;2");
		assertEquals(3, result);
	}

	@Test
	void customDelimiterWithMultipleNumbers() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("//;\n1;2;3");
		assertEquals(6, result);
	}

	@Test
	void singleNegativeNumberThrowsException() {
		StringCalculator calc = new StringCalculator();
		IllegalArgumentException exception = assertThrows(
			IllegalArgumentException.class,
			() -> calc.add("1,-2,3")
		);
		assertEquals("negatives not allowed: -2", exception.getMessage());
	}

	@Test
	void multipleNegativeNumbersThrowsExceptionWithAllNegatives() {
		StringCalculator calc = new StringCalculator();
		IllegalArgumentException exception = assertThrows(
			IllegalArgumentException.class,
			() -> calc.add("1,-2,-4,3")
		);
		assertEquals("negatives not allowed: -2,-4", exception.getMessage());
	}

	@Test
	void numbersGreaterThan1000AreIgnored() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("2,1001");
		assertEquals(2, result);
	}

	@Test
	void number1000IsIncluded() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1000,1");
		assertEquals(1001, result);
	}

	@Test
	void multipleLargeNumbersAreIgnored() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1001,1002,3");
		assertEquals(3, result);
	}
	
	@Test
	void delimiterOfAnyLengthInBracketsWorks() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("//[***]\n1***2***3");
		assertEquals(6, result);
	}

	@Test
	void customMultiCharDelimiterWithDifferentChars() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("//[abc]\n4abc5abc6");
		assertEquals(15, result);
	}

	@Test
	void delimiterWithSpecialRegexCharsRequiresExtraction() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("//[.*]\n1.*2.*3");
		assertEquals(6, result);
	}

	@Test
	void multipleDelimitersInBrackets() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("//[*][%]\n1*2%3");
		assertEquals(6, result);
	}

	@Test
	void multipleDelimitersWithDifferentLengths() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("//[aa][bbb]\n1aa2bbb3");
		assertEquals(6, result);
	}
}


