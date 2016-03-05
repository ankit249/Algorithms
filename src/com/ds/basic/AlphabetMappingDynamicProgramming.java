package com.ds.basic;

//** Answer is not right
/**
 * 
 * Given a mapping of alphabets to integers as follows: 
 * 
 * 1 = A 
 * 2 = B 
 * 3 = C 
 * ... 
 * 26 = Z 
 * 
 * Given any combination of the mapping numbers as string, return the number of ways in which the input string can be split into sub-strings and represented as character strings. For e.g. given 
 * "111" -> "AAA", "AK", "KA" -> 3 
 * Valid combinations are ({1,1,1}, {1,11},{11,1}) = 3 
 * "11" -> "AA", "K" -> 2 
 * Valid combinations are ({1,1},{11}) = 2 
 * "123" -> "ABC", "LC", "AW" -> 3 
 * Valid combinations are ({1,2,3},{1,23},{12,3}) = 3 
 * You don't have to return all the mappings, only the number of valid mappings.
 *
 */

/**
 * solution
 * 
 * this is pretty easy if you think in terms of Dp approach. 
 * Lets say we have String as "1" so our output will be 1 because we only form 'A' 
 * but if we add 2 to the existing string "12" then output is "AB" and "L" so if you see 
 * the logic is when you add a character to an existing string the number of combinations increase by combining last 2 digits 
 * in dp it can be formulized As 
 * d[i]=dp[i-1]+dp[i-2](if the last 2 digits combined is smaller than 27) 
 * else dp[i]=dp[i-1]; 
 * code is as below
 * 
 */

public class AlphabetMappingDynamicProgramming {

	public static long getMappingCount(String str) {

		int[] a = new int[str.length()];
		long[] Dp = new long[str.length()];

		for (int i = 0; i < a.length; i++) {
			// Character ch = str.charAt(i);
			a[i] = Integer.parseInt("" + str.charAt(i));
		}

		Dp[0] = 1;

		if (a[0] * 10 + a[1] < 27)
			Dp[1] = 2;
		else
			Dp[1] = 1;

		for (int i = 2; i < a.length; i++) {
			long combinedLast2didgits = 0;
			if (a[i - 1] * 10 + a[i] < 27)
				combinedLast2didgits = Dp[i - 2];

			Dp[i] = Dp[i - 1] + combinedLast2didgits + 1;
		}

		return Dp[Dp.length - 1];
	}

	public static void main(String[] args) {

		String string = "128";
		System.out.println(getMappingCount(string));
	}

}
