package com.ds.basic;

public class SetOfUniqueCharactersInString {

	public static void main(String[] args) {

		String string = "abbcbcba";
		char[] arr = new char[] { 'a', 'b', 'c' };

		int i = 0;
		int j = 3;

		while (true) {

		String part = string.substring(i, j);
			if (!isUnique(part) && j <= string.length()) {
				i++;
				j++;
				continue;
			} else {
				System.out.println(part);
				break;
			}
		}
		//
	}

	public static boolean isUnique(String part) {

		boolean flag = true;
		if (part.charAt(0) == part.charAt(1))
			flag = false;
		if (part.charAt(0) == part.charAt(2))
			flag = false;
		if (part.charAt(1) == part.charAt(2))
			flag = false;

		return flag;
	}

}
