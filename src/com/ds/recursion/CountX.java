package com.ds.recursion;

public class CountX {

	public static int countX(String str) {
		if (str.length() == 0)
			return 0;

		if (str.charAt(0) == 'x') {
			return 1 + countX(str.substring(1));
		} else {
			return countX(str.substring(1));
		}

	}

	public static void main(String[] args) {
		System.out.println(countX("x"));
		System.out.println(countX("h"));
		System.out.println(countX("xxhixx"));
		System.out.println(countX("xhixhix"));
		System.out.println(countX("hi"));
	}
}
