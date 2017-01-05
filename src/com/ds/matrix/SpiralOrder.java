package com.ds.matrix;

import java.util.ArrayList;

public class SpiralOrder {

	public static void main(String[] args) {

		//int[][] matrix = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
		int[][] matrix = { { 1, 2, 3, 4 }, { 10,11,12,5 }, { 9,8,7,6} };

		ArrayList<Integer> list = spiralOrder(matrix);
		System.out.println(list);
	}
	


	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0)
			return result;

		int m = matrix.length;
		int n = matrix[0].length;

		int x = 0;
		int y = 0;

		while (m > 0 && n > 0) {

			// if one row/column left, no circle can be formed
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					result.add(matrix[x][y++]);
				}
				break;
			} else if (n == 1) {
				for (int i = 0; i < m; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			}

			// below, process a circle

			// top - move right
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y++]);
			}

			// right - move down
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x++][y]);
			}

			// bottom - move left
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y--]);
			}

			// left - move up
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x--][y]);
			}

			x++;
			y++;
			m = m - 2;
			n = n - 2;
		}

		return result;
	}
}
