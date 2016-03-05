package com.ds.basic;

import java.util.HashMap;
import java.util.Scanner;

public class IceCreamParlor2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		for (int i = 0; i < input; i++) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int[] a = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = scanner.nextInt();
			}

			map.put(a[0], 1);
			for (int j = 1; j < a.length; j++) {
				if (map.containsKey(m - a[j])) {
					int index1 = map.get(m - a[j]);
					int index2 = j + 1;

					System.out.println(index1 + " " + index2);
				} else {
					map.put(a[j], j + 1);
				}
			}

		}
	}


}