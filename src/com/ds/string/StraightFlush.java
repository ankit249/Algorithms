package com.ds.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StraightFlush {
	private static String sample1 = "A23456789TJQK";
	private static String sample2 = "23456789TJQKA";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String cards[] = new String[5];
		String[] order = new String[5];
		int[] count_alphabet = new int[256];

		char last = 'x';
		for (int cards_i = 0; cards_i < 5; cards_i++) {
			cards[cards_i] = in.next();
			order[cards_i] = cards[cards_i].substring(0, 1);
			last = cards[cards_i].charAt(1);
			count_alphabet[last]++;
		}

		if (count_alphabet[last] != 5) {
			System.out.println("NO");
			return;
		}

		if (sample1.contains(sort1(order).toString()) || sample2.contains(sort2(order).toString())) {
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
	}

	private static String stringArrayToString(String[] string) {
		StringBuilder builder = new StringBuilder();
		for (String s : string) {
			builder.append(s);
		}
		return builder.toString();
	}

	private static String sort1(String[] string) {
		Arrays.sort(string, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return sample1.indexOf(s1) - sample1.indexOf(s2);
			}
		});
		return stringArrayToString(string);
	}

	private static String sort2(String[] string) {
		Arrays.sort(string, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return sample2.indexOf(s1) - sample2.indexOf(s2);
			}
		});
		return stringArrayToString(string);
	}
}
