package com.ds.string;

/**
 * When you click on a link of any tiny url, an HTTP Request is sent to their server with the full URL, 
 * like http //bit.ly/b9 (not a real one).
 * 
 * They read the path part (here b9), which maps to their Database.
 * 
 * In the Database, they find the real URL. Then they issue a redirect, which is a HTTP 302 response and the target URL
 * in the header.
 * 
 * Encoding Part:
 * 
 * One of the most popular URL shortening services simply take the ID in the database of the URL and then convert it to
 * Base 62[a-zA-Z0-9].
 * 
 */
public class TinyUrl {
	private static final String ALPHABET_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int BASE = ALPHABET_MAP.length();

	public static String encode(int IndexNum) {
		StringBuilder sb = new StringBuilder();

		while (IndexNum > 0) {
			sb.append(ALPHABET_MAP.charAt(IndexNum % BASE));
			IndexNum /= BASE;
		}
		return sb.reverse().toString();
	}

	public static int decode(String str) {
		int Num = 0;
		int len = str.length();

		for (int i = 0; i < len; i++) {
			Num = Num * BASE + ALPHABET_MAP.indexOf(str.charAt(i));
		}
		return Num;
	}

	public static void main(String[] args) {
		System.out.println("Encoding for 123 is " + encode(123));
		System.out.println("Decoding for b9 is " + decode("b9"));

		// System.out.println("hashcode of a string: " + "abc".hashCode());

	}
}