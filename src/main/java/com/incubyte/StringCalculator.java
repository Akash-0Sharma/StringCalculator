package com.incubyte;

public class StringCalculator {
	public int add(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}
		String[] parts = numbers.split(",");
		int sum = 0;
		for (String part : parts) {
			if (part.isEmpty()) {
				continue;
			}
			sum += Integer.parseInt(part);
		}
		return sum;
	}
}


