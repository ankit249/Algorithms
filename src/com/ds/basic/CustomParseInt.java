package com.ds.basic;

public class CustomParseInt {

	public static int parse(String string) {
		int number = 0;
		for (int i = 0; i < string.length(); i++) {
			number = number * 10 + Character.digit(string.charAt(i), 10);
		}
		return number;
	}

	public static void main(String[] args) {

		System.out.println(parse("123"));
	}
}
