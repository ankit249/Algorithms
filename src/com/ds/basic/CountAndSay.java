package com.ds.basic;


/**
 *  Write a program to find pattern. 

0: 1 
1: 11 
2: 21 
3: 1211 
4: 111221 
5: 312211 

Iterate over the previous number, and find count for same number number. Append that count before number. 

e.g., 

public String pattern(int input){} 

If input = 4, function should return 111221.

 
 */
public class CountAndSay {

	public static String countAndSay(int n) {

		String result = "1";
		int i = 0;
		while (i < n) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == result.charAt(j - 1)) {
					count++;
				} else {
					sb.append(count);
					sb.append(result.charAt(j - 1));
					count = 1;
				}
			}
			sb.append(count);
			sb.append(result.charAt(result.length() - 1));
			result = sb.toString();
			i++;
		}

		return result;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 8; i++) {
			System.out.println(countAndSay(i));
		}
	}

}
