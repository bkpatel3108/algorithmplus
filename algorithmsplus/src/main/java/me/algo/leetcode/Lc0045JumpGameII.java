package me.algo.leetcode;

import java.util.Arrays;

public class Lc0045JumpGameII {
	public int jump(int[] nums) {
		// return jumpRec(nums, 0);

		// Integer[] memo = new Integer[nums.length];
		// return jumpRecMemo(nums, 0, memo);

		return jumpDp(nums);
	}

	// Intution recursive solution
	public int jumpRec(int[] nums, int i) {
		if (i >= nums.length - 1)
			return 0;
		int jump = nums[i];
		int min = Integer.MAX_VALUE;
		for (int j = i + 1; j <= i + jump; j++) {
			min = Math.min(min, 1 + jumpRec(nums, j));
		}
		return min;
	}

	// memoization
	public int jumpRecMemo(int[] nums, int i, Integer[] memo) {
		if (i >= nums.length - 1)
			return 0;
		if (memo[i] != null)
			return memo[i];
		int jump = nums[i];
		int min = Integer.MAX_VALUE;
		for (int j = i + 1; j <= i + jump; j++) {
			min = Math.min(min, 1 + jumpRecMemo(nums, j, memo));
		}
		memo[i] = min;
		return memo[i];
	}

	// Dp from memoization
	public int jumpDp(int[] nums) {
		Integer[] table = new Integer[nums.length];
		Arrays.fill(table, Integer.MAX_VALUE);
		table[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			int jump = nums[i];
			for (int j = i + 1; j <= i + jump && j < nums.length; j++) {
				table[j] = Math.min(table[j], 1 + table[i]);
			}
		}

		return table[nums.length - 1];
	}
}
