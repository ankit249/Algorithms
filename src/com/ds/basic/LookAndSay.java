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
public class LookAndSay {
	public static void main(String[] args) {

		String string = "1";
		for (int i = 1; i <= 8; i++) {
			System.out.println(string);
			string = lookAndSay(string);
		}
	}

	public static String lookAndSay(String string) {

		StringBuilder sb = new StringBuilder();
		char first = string.charAt(0);
		int count = 1;
		if (string.length() == 1) {
			sb.append(count);
			sb.append(first);
			return sb.toString();
		}
		for (int i = 1; i < string.length(); i++) {
			if (first == string.charAt(i)) {
				count++;
			} else {
				sb.append(count);
				sb.append(first);
				first = string.charAt(i);
				count = 1;
			}
			if (i == string.length() - 1) {
				sb.append(count);
				sb.append(first);
			}
		}
		return sb.toString();
	}
}
