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

	public static String decode(int n) {
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			sb.append(ALPHABET_MAP.charAt(n % BASE));
			n = n / BASE;
		}
		return sb.reverse().toString();
	}

	public static int encode(String str) {
		int n = 0;

		for (int i = 0; i < str.length(); i++) {
			n = n * BASE + ALPHABET_MAP.indexOf(str.charAt(i));
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println("Encoding for b9 is " + encode("b9"));
		System.out.println("Decoding for 123 is " + decode(123));

		System.out.println("Encoding for ba9zz is " + encode("ba9zz"));
		System.out.println("Decoding for 15012395 is " + decode(15012395));
	}
}