package me.algo.leetcode;

public class Lc0209MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		// sliding window start
		int start = 0;
		// sliding window end
		int end = 0;
		int currSum = 0;
		int min = Integer.MAX_VALUE;
		while (end < nums.length) {
			currSum += nums[end];
			while (currSum >= s) {
				min = Math.min(end - start + 1, min);
				currSum -= nums[start];
				start++;
			}
			end++;
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
