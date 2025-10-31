package com.incubyte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		List<Integer> negatives = new ArrayList<>();
		int sum = 0;
		for (String part : parts) {
			if (part.isEmpty()) {
				continue;
			}
			int num = Integer.parseInt(part);
			if (num < 0) {
				negatives.add(num);
			} else {
				sum += num;
			}
		}
		
		if (!negatives.isEmpty()) {
			String negativesList = negatives.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(","));
			throw new IllegalArgumentException("negatives not allowed: " + negativesList);
		}
		
		return sum;
	}
}


