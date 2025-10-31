package com.incubyte;

public class StringCalculator {
	public int add(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}
		
		String delimiter = ",|\\n";
		String numbersToProcess = numbers;
		
		if (numbers.startsWith("//")) {
			int newlineIndex = numbers.indexOf('\n');
			if (newlineIndex == -1) {
				throw new IllegalArgumentException("Invalid custom delimiter format");
			}
			String delimiterPart = numbers.substring(2, newlineIndex);
			numbersToProcess = numbers.substring(newlineIndex + 1);
			delimiter = delimiterPart;
		}
		
		String[] parts = numbersToProcess.split(delimiter);
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


