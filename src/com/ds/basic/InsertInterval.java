package com.ds.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * input given is non - overlapping
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

public class InsertInterval {

	public static ArrayList<Interval> insert(ArrayList<Interval> list, Interval input) {
		Collections.sort(list, new Comparator<Interval>() {
			public int compare(Interval i, Interval j) {
				if (i.lo == j.lo) {
					return i.hi - j.hi;
				}
				return i.lo - j.hi;
			}
		});
		System.out.println("sorted list: " + list + " ; Now inserting " + input);
		list.add(input);

		return merge(list);
	}

	public static ArrayList<Interval> merge(ArrayList<Interval> list) {
		Collections.sort(list, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.lo == i2.lo) {
					return i1.hi - i2.hi;
				}
				return i1.lo - i2.lo;
			}
		});
		// System.out.println("sorted list: " + list);

		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = list.get(0);
		result.add(prev);
		for (int i = 1; i < list.size(); i++) {
			Interval current = list.get(i);
			if (prev.hi >= current.lo) {
				Interval interval = new Interval(prev.lo, Math.max(prev.hi, current.hi));
				prev = interval;
			} else {
				prev = current;
			}
			removeIfExist(result, prev);
			result.add(prev);

		}

		return result;
	}

	private static void removeIfExist(ArrayList<Interval> result, Interval prev) {
		if (result.size() > 0) {
			Interval existing = result.get(result.size() - 1);
			if (existing.lo == prev.lo) {
				result.remove(result.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 3));
		list.add(new Interval(6, 9));
		System.out.println("Input: " + list);
		System.out.println("insert interval: " + insert(list, new Interval(2, 5)));
		System.out.println("-----------------------------------------------------");
		list = new ArrayList<Interval>();
		list.add(new Interval(8, 10));
		list.add(new Interval(1, 2));
		list.add(new Interval(3, 5));
		list.add(new Interval(6, 7));
		list.add(new Interval(12, 16));
		System.out.println("Input: " + list);
		System.out.println("merged interval: " + insert(list, new Interval(4, 9)));
		System.out.println("-----------------------------------------------------");
	}
}
