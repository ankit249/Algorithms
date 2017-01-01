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

	public static int getsum(int a, int b) {
		int c = 0;
		while (b != 0) {
			// System.out.println("" + a + "; " + b + "; " + c);
			c = a & b;
			a = a ^ b;
			b = c << 1;
		}

		return a;
	}

	public static void main(String[] args) {
		System.out.println(sum(1, 3));
		System.out.println(sum(1, -3));
		System.out.println(sum(-1, 3));
		System.out.println(sum(-1, -3));
		
		System.out.println(getsum(5, 3));
		System.out.println(getsum(1, -3));
		System.out.println(getsum(-1, 3));
		System.out.println(getsum(-1, -3));

		for (int i = 1; i < 6; i++) {
			System.out.println(i << 1);
		}
	}
}
