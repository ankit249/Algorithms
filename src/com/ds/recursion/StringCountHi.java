package com.ds.recursion;

public class StringCountHi {

	public int countHi(String str) {
		if (str == null || str.length() < 1)
			return 0;
		if (str.indexOf("hi") == -1) {
			return 0;
		} else {
			return 1 + countHi(str.substring(str.indexOf("hi") + 2, str.length()));
		}
	}

}
