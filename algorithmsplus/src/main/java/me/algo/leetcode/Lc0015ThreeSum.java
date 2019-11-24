package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc0015ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (left > i + 1 && nums[left] == nums[left - 1]) {
					left++;
					continue;
				}
				if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
					right--;
					continue;
				}
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
}
