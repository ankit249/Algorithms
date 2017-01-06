package com.ds.math;

/*
 Given a positive integer, return its corresponding column title as appear in an Excel sheet. For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 
 */
public class ExcelConverNumberToTitle {

	// The key is n--. The minimum in 26-bit number is mapped to 1, not 0.
	public static String toTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			n--; // TODO RATTA
			char c = (char) (n % 26 + 'A');
			sb.append(c);
			n = n / 26;
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(toTitle(25));
		System.out.println(toTitle(26));
		System.out.println(toTitle(27));
		System.out.println(toTitle(3));
	}
}
