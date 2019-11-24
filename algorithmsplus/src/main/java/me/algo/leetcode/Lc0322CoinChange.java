package me.algo.leetcode;

import java.util.Arrays;

public class Lc0322CoinChange {
	// public int coinChange(int[] coins, int amount) {
	// Integer[] memo = new Integer[amount+1];
	// int min = coinChange(coins, amount, memo);
	// return min;
	// }

	// public int coinChange(int[] coins, int rem, Integer[] memo) {
	// if(rem < 0){
	// return -1;
	// }
	// if(rem == 0){
	// return 0;
	// }
	// if(memo[rem] != null){
	// return memo[rem];
	// }

	// int minCoins = -1;
	// for(int i=0; i<coins.length; i++){
	// int currMinCoins = coinChange(coins, rem - coins[i], memo);
	// if(currMinCoins != -1)
	// minCoins = minCoins == -1 ? 1 + currMinCoins: Math.min(minCoins, 1 +
	// currMinCoins);
	// }
	// memo[rem] = minCoins;
	// return minCoins;
	// }

	// Coin change dp
	public int coinChange(int[] coins, int amount) {
		int[] table = new int[amount + 1];
		Arrays.fill(table, -1);
		table[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0 && table[i - coins[j]] >= 0) {
					table[i] = table[i] == -1 ? 1 + table[i - coins[j]] : Math.min(table[i], 1 + table[i - coins[j]]);
				}
			}
		}
		return table[amount];
	}
}
