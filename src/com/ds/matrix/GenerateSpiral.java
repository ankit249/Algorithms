package com.ds.matrix;

public class GenerateSpiral {

	private static void spiral(int m, int n) {
		final int[][] a = new int[m][n];
		spiralRecurse(a, 0, 0, m, n, 0);
		printMatrix(a);
	}

	private static void spiralRecurse(final int[][] a, int x, int y, int m, int n, int value) {
		if (m <= 0 || n <= 0) {
			return;
		}

		// only one element left
		if (m == 1 && n == 1) {
			a[x][y] = ++value;
			return;
		}

		// Top side: Move from left to right
		for (int i = 0; i < n - 1; i++) {
			a[x][y++] = ++value;
		}

		// Right side: Move from top to bottom
		for (int i = 0; i < m - 1; i++) {
			a[x++][y] = ++value;
		}

		// Bottom side: Move from right to left
		for (int i = 0; i < n - 1; i++) {
			a[x][y--] = ++value;
		}

		// Left side: Move from bottom to top
		for (int i = 0; i < m - 1; i++) {
			a[x--][y] = ++value;
		}

		// By the time we reached here, we finished walking the external 'circle',
		// Now, we want to start walking the next inner circle, by incrementing
		// m & n and adjusting the matrix limits
		spiralRecurse(a, x + 1, y + 1, m - 2, n - 2, value);
	}

	private static void printMatrix(int[][] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		spiral(3, 3);
	}
}
