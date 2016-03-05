package com.ds.recursion;

/**
Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping. 

strCount("catcowcat", "cat") → 2
strCount("catcowcat", "cow") → 1
strCount("catcowcat", "dog") → 0
*/

public class SubStringCount {

	public static int strCount(String str, String sub) {
		if (str.indexOf(sub) == -1) {
			return 0;
		}

		return 1 + strCount(str.substring(str.indexOf(sub) + sub.length()), sub);
	}

	public static void main(String[] args) {
		System.out.println(strCount("catcowcat", "cat"));
	}
}
