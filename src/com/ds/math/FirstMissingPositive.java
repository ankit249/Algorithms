package com.ds.math;

public class FirstMissingPositive {
	int firstMissingPositiveAnd0(int a[]) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			// when the ith element is not i
			while (a[i] != i) {
				// no need to swap when ith element is out of range [0,n]
				if (a[i] < 0 || a[i] >= n)
					break;

				// handle duplicate elements
				if (a[i] == a[a[i]])
					break;
				// swap elements
				int temp = a[i];
				a[i] = a[temp];
				a[temp] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			if (a[i] != i)
				return i;
		}

		return n;
	}
}
