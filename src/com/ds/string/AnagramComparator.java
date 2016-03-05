package com.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AnagramComparator implements Comparator<String> {

	public int compare(String s1, String s2) {
		return sort(s1).compareTo(sort(s2));
	}

	public String sort(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("cat");
		list.add("act");
		list.add("mouse");
		list.add("noise");
		list.add("omuse");
		list.add("cbt");

		String[] array = new String[list.size()];
		array = list.toArray(array);

		Arrays.sort(array, new AnagramComparator());
		System.out.println(Arrays.toString(array));
	}

}
