package com.ds.basic;

import java.util.Scanner;

public class MaximizingOr {

	private static int maxXor(int l, int r) {
		int result = r & ~l;
		int b = 0;
		for (; result != 0; result = result >> 1) {
			b = b << 1 | 1;
		}
		return b;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;
		int _l;

		byte b = 5;
		// System.out.println("5 >> 1:  " + (5 >> 1));
		// System.out.println("~5:  " + (~5));
		// System.out.println("~4:  " + (~4));
		// System.out.println("~1:  " + (~1));

		_l = Integer.parseInt(in.nextLine());

		int _r;
		_r = Integer.parseInt(in.nextLine());

		res = maxXor(_l, _r);
		System.out.println(res);

	}
}
