package com.ds.math;

import java.util.Stack;

public class LargestRectangleHistogram {
	public static int largestRectangleArea(int[] a) {
		if (a == null || a.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();

		int max = 0;
		int i = 0;

		while (i < a.length) {
			// push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || a[i] >= a[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = a[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}

		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = a[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 6, 5 };
		System.out.println(largestRectangleArea(a));
	}

}
