package com.ds.basic;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");

		for (Map.Entry<Integer, String> s : map.entrySet()) {
			System.out.print(s.getKey() + " ");
			System.out.print(s.getValue());
			System.out.println();
		}

		for (Integer a : map.keySet()) {
			System.out.println(map.get(a));
		}
	}
}
