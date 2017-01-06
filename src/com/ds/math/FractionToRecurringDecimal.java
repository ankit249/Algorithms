package com.ds.math;

import java.util.HashMap;
import java.util.Map;

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.

For example,
Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {

	public static String fractionToDecimal(int numerator, int denominator) {
		if(numerator == 0 || denominator == 0) return "0";
		String result = "";
		

		long res = numerator / denominator;
		result = result + res;

		long remainder = (numerator % denominator) * 10;
		if (remainder == 0) {
			return result;
		}
		
		// right-hand side of decimal point
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder);
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}

			// continue
			map.put(remainder, result.length());
			res = remainder / denominator;
			result += String.valueOf(res);
			remainder = (remainder % denominator) * 10;
		}

		return result;
	}

	public static void main(String[] args) {
		// System.out.println(fractionToDecimal(1, 2));
		System.out.println(fractionToDecimal(2, 3));
	}
}
