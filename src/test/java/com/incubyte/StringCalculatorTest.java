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
}


