package me.algo.leetcode;

import java.util.Arrays;

public class Lc300LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		// return lengthOfLISSuffix(nums);
		// return lengthOfLISPrefix(nums);
		return lengthOfLISBottomUp(nums);
	}

	// Using suffix technique
	public int lengthOfLISSuffix(int[] nums) {
		Integer[] memo = new Integer[nums.length];
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, lengthOfLISSuffix(nums, i, memo));
		}
		return max;
	}

	public int lengthOfLISSuffix(int[] nums, int i, Integer[] memo) {
		if (memo[i] != null)
			return memo[i];
		int max = 1;
		for (int j = i + 1; j < nums.length; j++) {
			if (nums[j] > nums[i]) {
				max = Math.max(max, 1 + lengthOfLISSuffix(nums, j, memo));
			}
		}
		memo[i] = max;
		return memo[i];
	}

	// Using prefix technique
	public int lengthOfLISPrefix(int[] nums) {
		Integer[] memo = new Integer[nums.length];
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, lengthOfLISPrefix(nums, i, memo));
		}
		return max;
	}

	public int lengthOfLISPrefix(int[] nums, int i, Integer[] memo) {
		if (memo[i] != null)
			return memo[i];
		int max = 1;
		for (int j = 0; j < i; j++) {
			if (nums[j] < nums[i]) {
				max = Math.max(max, 1 + lengthOfLISPrefix(nums, j, memo));
			}
		}
		memo[i] = max;
		return memo[i];
	}

	// Using bottom up technique
	public int lengthOfLISBottomUp(int[] nums) {
		int[] table = new int[nums.length];
		Arrays.fill(table, 1);
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					table[i] = Math.max(table[i], 1 + table[j]);
				}
			}
			max = Math.max(max, table[i]);
		}
		return max;
	}
}
