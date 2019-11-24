package me.algo.leetcode;

import java.util.Arrays;

public class Lc0134GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = Arrays.stream(gas).sum();
		int totalCost = Arrays.stream(cost).sum();

		if (totalCost > totalGas)
			return -1;

		int balanceGas = 0;
		int index = 0;
		for (int i = 0; i < gas.length; i++) {
			int currDiff = gas[i] - cost[i];
			if (currDiff >= 0 && balanceGas < 0) {
				index = i;
				balanceGas = 0;
			}
			balanceGas = balanceGas + currDiff;
		}

		return index;
	}
}
