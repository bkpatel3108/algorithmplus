package me.algo.leetcode;

public class Lc0673NumberOfLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		return findNumberOfLISSuffix(nums);
	}

	// Using suffix
	public int findNumberOfLISSuffix(int[] nums) {
		int maxLen = 1;
		int ways = 0;
		LIS[] memo = new LIS[nums.length];
		for (int i = 0; i < nums.length; i++) {
			LIS ilis = findNumberOfLISSuffix(nums, i, memo);
			if (ilis.length > maxLen) {
				maxLen = ilis.length;
				ways = ilis.ways;
			} else if (ilis.length == maxLen) {
				ways += ilis.ways;
			}
		}
		return ways;
	}

	public LIS findNumberOfLISSuffix(int[] nums, int i, LIS[] memo) {
		if (memo[i] != null)
			return memo[i];
		LIS lis = new LIS(1, 1);
		for (int j = i + 1; j < nums.length; j++) {
			if (nums[j] > nums[i]) {
				LIS jlis = findNumberOfLISSuffix(nums, j, memo);
				int jl = 1 + jlis.length;
				if (jl > lis.length) {
					lis.length = jl;
					lis.ways = jlis.ways;
				} else if (jl == lis.length) {
					lis.ways += jlis.ways;
				}
			}
		}
		memo[i] = lis;
		return memo[i];
	}

	class LIS {
		int length;
		int ways;

		LIS(int length, int ways) {
			this.length = length;
			this.ways = ways;
		}
	}

	// TODO: create Prefix solution

	// TODO: create BottomUp solution
}
