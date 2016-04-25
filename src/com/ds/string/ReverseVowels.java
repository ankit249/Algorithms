package com.ds.string;

public class ReverseVowels {

	public static String reverseVowels(String string) {
		String vowels = "aeiouAEIOU";

		int lo = 0;
		int hi = string.length() - 1;
		char[] ch = string.toCharArray();

		while (lo < hi) {

			if (!vowels.contains(String.valueOf(string.charAt(lo)))) {
				lo++;
				continue;
			}

			if (!vowels.contains(String.valueOf(string.charAt(hi)))) {
				hi--;
				continue;
			}

			// swap
			swap(ch, lo, hi);
			lo++;
			hi--;
		}

		return String.valueOf(ch);
	}

	public static void swap(char[] ch, int lo, int hi) {
		char tmp = ch[lo];
		ch[lo] = ch[hi];
		ch[hi] = tmp;
	}

	public static void main(String[] args) {
		System.out.println(reverseVowels("Ankiit"));
	}
}
