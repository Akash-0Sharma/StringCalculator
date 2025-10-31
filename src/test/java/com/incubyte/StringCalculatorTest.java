package com.incubyte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}


