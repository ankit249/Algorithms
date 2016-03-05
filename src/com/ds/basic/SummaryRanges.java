package com.ds.basic;

import java.util.ArrayList;
import java.util.List;

//http://www.programcreek.com/2014/07/leetcode-summary-ranges-java/
public class SummaryRanges {

	public static List<String> ranges(int[] a) {
		List<String> list = new ArrayList<String>();
		int lo = 0;
		int hi = 0;

		for (int i = 1; i < a.length; i++) {
			if (a[i] - a[i - 1] == 1) {
				hi++;
			} else {
				if (lo == hi) {
					list.add(String.valueOf(a[lo]));
				} else {
					list.add(a[lo] + "-->" + a[hi]);
				}
				lo = i;
				hi = i;
			}
		}
		if (lo == hi) {
			list.add(String.valueOf(a[lo]));
		} else {
			list.add(a[lo] + "-->" + a[hi]);
		}
		return list;
	}

	public static void main(String[] args) {
		//int[] a = { 0, 1, 2, 4, 5, 7 };
		//int[] a = { 3, 5, 6, 7, 8, 9 };
		int[] a = { 4, 6, 7, 8, 10, 12, 15, 16, 17, 25 };
		System.out.println(ranges(a));
	}
}
