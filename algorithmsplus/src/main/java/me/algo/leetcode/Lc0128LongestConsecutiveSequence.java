package me.algo.leetcode;

public class Lc0128LongestConsecutiveSequence {
	class MaxPair {
		int currMax;
		int max;

		MaxPair(int currMax, int max) {
			this.currMax = currMax;
			this.max = max;
		}
	}

	public int longestConsecutive(int[] nums) {
		return longestConsecutiveRec(nums, nums.length - 1, new MaxPair(1, 1), new MaxPair[nums.length]).max;
	}

	public MaxPair longestConsecutiveRec(int[] nums, int n, MaxPair maxPair, MaxPair[] memo) {
		if (memo[n] != null)
			return memo[n];
		int currMax = 1;
		for (int i = 0; i < n; i++) {
			int iMax = longestConsecutiveRec(nums, i, new MaxPair(1, 1), memo).max;
			maxPair.max = Math.max(maxPair.max, iMax);
			if (nums[i] < nums[n]) {
				currMax = Math.max(currMax, 1 + iMax);
			}
		}
		maxPair.currMax = currMax;
		maxPair.max = Math.max(maxPair.max, currMax);
		memo[n] = maxPair;
		return maxPair;
	}
}
