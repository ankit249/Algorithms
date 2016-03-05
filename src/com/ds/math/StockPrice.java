package com.ds.math;

public class StockPrice {
	private static int buySellProfit(int[] a) {
		int profit = Integer.MIN_VALUE;
		int buy = 0;
		int sell = 0;

		int min = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[min]) {
				min = i;
			} else if (a[i] - a[min] > profit) {
				buy = a[min];
				sell = a[i];
				profit = sell - buy;
			}
		}

		System.out.println("buy at: " + buy + " and sell at: " + sell);

		return profit;
	}

	public static int maxProfit(int[] prices) {
		int profit = 0;
		int minElement = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - minElement);
			minElement = Math.min(minElement, prices[i]);
		}
		return profit;
	}

	public static void main(String[] args) {
		System.out.println(buySellProfit(new int[] { 15, 50, 10, 45 }));
		System.out.println(buySellProfit(new int[] { 10, 45, 15, 50 }));

		System.out.println(maxProfit(new int[] { 15, 50, 10, 45 }));
		System.out.println(maxProfit(new int[] { 10, 45, 15, 50 }));
	}
}
