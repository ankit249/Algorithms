package com.ds.basic;

public class SumWithoutUsingPlusSign {

	public static int sum(int a, int b) {
		while (b != 0) {
			if (b < 0) {
				a--;
				b++;
			} else {
				a++;
				b--;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(sum(1, 3));
		System.out.println(sum(1, -3));
		System.out.println(sum(-1, 3));
		System.out.println(sum(-1, -3));
	}
}
