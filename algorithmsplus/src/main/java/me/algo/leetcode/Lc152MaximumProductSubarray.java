package me.algo.leetcode;

public class Lc152MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int max = nums[0];
		int minEndingHere = nums[0];
		int maxEndingHere = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int minEndingPrev = minEndingHere;
			int maxEndingPrev = maxEndingHere;

			minEndingHere = Math.min(nums[i], Math.min(nums[i] * minEndingPrev, nums[i] * maxEndingPrev));
			maxEndingHere = Math.max(nums[i], Math.max(nums[i] * minEndingPrev, nums[i] * maxEndingPrev));
			max = Math.max(max, maxEndingHere);
		}
		return max;
	}
}
