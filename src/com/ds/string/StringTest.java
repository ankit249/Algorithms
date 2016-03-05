package com.ds.string;

public class StringTest {
	public static void main(String[] args) {
		String s = "karoyamaro";
		int half_length = s.length() / 2;
		System.out.println(s.substring(0, half_length));
		System.out.println(s.substring(half_length, s.length()));

		System.out.println("abcd".substring(0, 4));
	}
}
