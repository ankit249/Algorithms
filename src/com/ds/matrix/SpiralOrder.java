package com.ds.matrix;

import java.util.ArrayList;

public class SpiralOrder {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		// System.out.println(matrix.length);

		// System.out.println(matrix[0].length);

		// System.out.println(matrix[1][0]);

		ArrayList<Integer> list = spiralOrder(matrix);
		System.out.println(list);
	}
	


	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0)
			return result;

		int row = matrix.length;
		int col = matrix[0].length;

		int x = 0;
		int y = 0;

		while (row > 0 && col > 0) {

			// if one row/column left, no circle can be formed
			if (row == 1) {
				for (int i = 0; i < col; i++) {
					result.add(matrix[x][y++]);
				}
				break;
			} else if (col == 1) {
				for (int i = 0; i < row; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			}

			// below, process a circle

			// top - move right
			for (int i = 0; i < col - 1; i++) {
				result.add(matrix[x][y++]);
			}

			// right - move down
			for (int i = 0; i < row - 1; i++) {
				result.add(matrix[x++][y]);
			}

			// bottom - move left
			for (int i = 0; i < col - 1; i++) {
				result.add(matrix[x][y--]);
			}

			// left - move up
			for (int i = 0; i < row - 1; i++) {
				result.add(matrix[x--][y]);
			}

			x++;
			y++;
			row = row - 2;
			col = col - 2;
		}

		return result;
	}
}
