package com.ds.recursion;

public class makeChangeCoins {
	public static int makeChange(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, next_denom);
		}
		return ways;
	}

	public static void main(String[] args) {
		System.out.println(makeChange(25, 25));

		System.out.println(coinChange(new int[] { 1, 2, 3 }, 4));
	}

	static int coinChange(int[] coins, int amount) {
		int INT_MAX = 20;

		if (amount == 0)
			return 0;
		int[] res = new int[INT_MAX]; // (amount + 1, INT_MAX)
		for (int i = 0; i < coins.length; i++)
			if (coins[i] < amount + 1)
				res[coins[i]] = 1;
		for (int i = 1; i <= amount; i++)
			for (int j = 0; j < coins.length; j++)
				if (i - coins[j] > 0 && res[i - coins[j]] != INT_MAX)
					res[i] = Math.min(res[i], res[i - coins[j]] + 1);
		return res[amount] == INT_MAX ? -1 : res[amount];
	}

}
