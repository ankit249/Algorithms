package com.ds.string;

import java.util.TreeMap;

/*
 
https://www.reddit.com/r/NoStupidQuestions/comments/2tngkh/why_is_49_xlix_instead_of_il_in_the_roman_numeral/

You can only subtract a power of ten, and only from the next two higher "digits". The digits are {I, V, X, L, C, D, M}.
I can be subtracted only from V and X
X can be subtracted only from L and C
C can be subtracted only from D and M

*/

public class DecimalToRoman {

	final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

	static {

		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");

	}

	public final static String toRoman(int number) {
		int l = map.floorKey(number);
		if (number == l) {
			return map.get(number);
		}
		return map.get(l) + toRoman(number - l);
	}

	public static void main(String[] args) {
		System.out.println(toRoman(49));
	}

}
