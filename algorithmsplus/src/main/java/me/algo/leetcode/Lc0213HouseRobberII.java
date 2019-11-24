package me.algo.leetcode;

public class Lc0213HouseRobberII {
	public int rob(int[] nums) {
		Integer[][] memo = new Integer[nums.length + 2][2];
		return rob(nums, 0, false, memo);
	}

	public int rob(int[] nums, int i, boolean firstUsed, Integer[][] memo) {
		if (firstUsed && memo[i][0] != null)
			return memo[i][0];
		if (!firstUsed && memo[i][1] != null)
			return memo[i][1];

		int max = 0;
		if (i < nums.length && !(i == nums.length - 1 && firstUsed)) {
			if (i == 0)
				max = Math.max(max, nums[i] + rob(nums, i + 2, true, memo));
			else
				max = Math.max(max, nums[i] + rob(nums, i + 2, firstUsed, memo));

			max = Math.max(max, rob(nums, i + 1, firstUsed, memo));
		}

		if (firstUsed)
			memo[i][0] = max;
		else
			memo[i][1] = max;
		return max;
	}
}
