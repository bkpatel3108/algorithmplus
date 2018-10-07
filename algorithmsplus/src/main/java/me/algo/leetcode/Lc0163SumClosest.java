package me.algo.leetcode;

import java.util.Arrays;

public class Lc0163SumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int result = Integer.MAX_VALUE;
		int diff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == target) {
					return target;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
				int newDiff = Math.abs(sum - target);
				if (newDiff < diff) {
					diff = newDiff;
					result = sum;
				}
			}
		}
		return result;
	}
}
