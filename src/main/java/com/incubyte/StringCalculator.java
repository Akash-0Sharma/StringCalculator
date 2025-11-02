package com.incubyte;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
			
			// Check if delimiter is in brackets format (single or multiple)
			if (delimiterPart.startsWith("[")) {
				// Extract all delimiters from brackets: [delim1][delim2]...
				List<String> delimiters = new ArrayList<>();
				Pattern bracketPattern = Pattern.compile("\\[(.*?)\\]");
				Matcher matcher = bracketPattern.matcher(delimiterPart);
				while (matcher.find()) {
					delimiters.add(matcher.group(1));
				}
				
				if (!delimiters.isEmpty()) {
					// Escape each delimiter and combine with | (OR operator)
					delimiter = delimiters.stream()
						.map(Pattern::quote)
						.collect(Collectors.joining("|"));
				} else {
					// Fallback to single bracket extraction
					String extractedDelimiter = delimiterPart.substring(1, delimiterPart.length() - 1);
					delimiter = Pattern.quote(extractedDelimiter);
				}
			} else {
				// Single character delimiter 
				delimiter = delimiterPart;
			}
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
			} else if (num <= 1000) {
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


