package me.algo.leetcode;

public class Lc0312BurstBalloons {
	public int maxCoins(int[] nums) {
		return maxCoins(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]);
	}

	public int maxCoins(int[] nums, int l, int r, Integer[][] memo) {
		if (l > r)
			return 0;
		if (memo[l][r] != null)
			return memo[l][r];
		int max = 0;
		for (int i = l; i <= r; i++) {
			int curr = ((l == 0 ? 1 : nums[l - 1]) * nums[i] * (r == nums.length - 1 ? 1 : nums[r + 1]));
			max = Math.max(max, maxCoins(nums, l, i - 1, memo) + curr + maxCoins(nums, i + 1, r, memo));
		}
		memo[l][r] = max;
		return max;
	}
}
