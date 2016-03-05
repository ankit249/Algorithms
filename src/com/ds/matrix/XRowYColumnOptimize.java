package com.ds.matrix;


public class XRowYColumnOptimize {

	public static void main(String[] args) {
		int[][] list = { { 0, 1 }, { 1, 0 }, { 1, 2 } };
		int[][] arr = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		setArray(list, arr);

		// System.out.println(BitSet.valueOf(new byte[0XFF]));
	}

	public static void setArray(int[][] list, int[][] arr) {
		for (int i = 0; i < list.length; i++) {
			arr[list[i][0]][list[i][1]] = 0;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}


}
