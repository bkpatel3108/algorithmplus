package me.algo.leetcode;

public class Lc0122BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int prev = 0;
		int start = Integer.MAX_VALUE;
		for (int price : prices) {
			if (price < prev) {
				int profit = prev - start;
				if (profit > 0)
					maxProfit = maxProfit + profit;
				start = price;
			}
			start = Math.min(start, price);
			prev = price;

		}
		if (prices.length > 0 && start < prices[prices.length - 1]) {
			maxProfit += prices[prices.length - 1] - start;
		}
		return maxProfit;
	}
}
