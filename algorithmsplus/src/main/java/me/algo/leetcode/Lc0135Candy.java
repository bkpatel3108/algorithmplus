package me.algo.leetcode;

public class Lc0135Candy {
	public int candy(int[] ratings) {
		int candyTotal = 0;
		Integer[] memo = new Integer[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			candyTotal += candy(ratings, i, memo);
		}
		return candyTotal;
	}

	public int candy(int[] ratings, int i, Integer[] memo) {
		if (i < 0 || i > ratings.length - 1)
			return 0;
		if (memo[i] != null) {
			return memo[i];
		}
		if ((i == 0 || ratings[i] <= ratings[i - 1]) && (i == ratings.length - 1 || ratings[i] <= ratings[i + 1])) {
			memo[i] = 1;
		} else if ((i == 0 || ratings[i] > ratings[i - 1])
				&& (i == ratings.length - 1 || ratings[i] <= ratings[i + 1])) {
			memo[i] = 1 + candy(ratings, i - 1, memo);
		} else if ((i == 0 || ratings[i] <= ratings[i - 1])
				&& (i == ratings.length - 1 || ratings[i] > ratings[i + 1])) {
			memo[i] = 1 + candy(ratings, i + 1, memo);
		} else {
			memo[i] = 1 + Math.max(candy(ratings, i - 1, memo), candy(ratings, i + 1, memo));
		}
		return memo[i];
	}
}
