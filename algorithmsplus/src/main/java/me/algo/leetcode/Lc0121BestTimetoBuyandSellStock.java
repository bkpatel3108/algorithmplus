package me.algo.leetcode;

public class Lc0121BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int currMin = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int price : prices) {
			int profit = price - currMin;
			maxProfit = Math.max(maxProfit, profit);
			currMin = Math.min(currMin, price);
		}
		return maxProfit;
	}
}
