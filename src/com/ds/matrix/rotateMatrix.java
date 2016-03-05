package com.ds.matrix;

public class rotateMatrix {

	// rotate clockwise.not in place...
	public static int[][] rotateNotInPlace(int[][] matrix) {
		int n = matrix.length;
		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = matrix[n - j - 1][i];
			}
		}

		return result;
	}

	// in place clockwise rotate
	public static int[][] rotateInPlace(int[][] m) {
		int n = m.length;

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil((double) n / 2); j++) { // for odd length matrix , for even lenth matrix
																	// n/2 will just work fine.
				int tmp = m[i][j];
				m[i][j] = m[n - 1 - j][i];
				m[n - 1 - j][i] = m[n - 1 - i][n - 1 - j];
				m[n - 1 - i][n - 1 - j] = m[j][n - 1 - i];
				m[j][n - 1 - i] = tmp;
			}
		}

		return m;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][3];

		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;

		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;

		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;

		printMatrix(matrix);

		int[][] result = rotateNotInPlace(matrix);
		System.out.println("result*****");
		printMatrix(result);

		// rotate in place
		System.out.println("result in place *****");
		matrix = rotateInPlace(matrix);
		printMatrix(matrix);

	}

	private static void printMatrix(int[][] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
