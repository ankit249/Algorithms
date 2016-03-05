package com.ds.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		for (int i = 0; i < input; i++) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = scanner.nextInt();
			}
			int[] b = new int[n];
			System.arraycopy(a, 0, b, 0, a.length);
			Arrays.sort(b);
			// System.out.println(Arrays.toString(b));
			int lo = 0;
			int hi = b.length - 1;
			while (lo <= hi) {
				if (b[lo] + b[hi] == m) {
					printIndex(a, b[lo], b[hi]);
					lo++;
					hi--;
					break;
				} else if (b[lo] + b[hi] < m) {
					lo++;
				} else {
					hi--;
				}
			}
			System.out.println();
		}
	}

	private static void printIndex(int[] a, int value1, int value2) {
		int index1 = 0;
		int index2 = 0;

		List<Integer> list = new ArrayList<Integer>();
		list.add(value1);
		list.add(value2);

		for (int i = 0; i < a.length; i++) {
			if (list.contains(a[i])) {
				index1 = i + 1;
				removeElement(list, a[i]);
				break;
			}
		}

		boolean flag = true;
		for (int j = 0; j < a.length; j++) {
			if (list.contains(a[j])) {
				if (value1 == value2 && flag) {
					flag = false;
				} else {
					index2 = j + 1;
					break;
				}
			}
		}
		System.out.print(index1 + " " + index2);
	}

	private static void removeElement(List<Integer> list, int item) {
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer a = it.next();
			if (a == item) {
				it.remove();
				break;
			}
		}
	}
}