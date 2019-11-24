package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc0047PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		permuteUnique(nums, new ArrayList<Integer>(), result, new boolean[nums.length]);
		return result;
	}

	public void permuteUnique(int[] nums, List<Integer> currList, List<List<Integer>> result, boolean[] used) {
		if (currList.size() == nums.length) {
			result.add(new ArrayList<Integer>(currList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i] && (i == 0 || used[i - 1] || nums[i - 1] != nums[i])) {
				used[i] = true;
				currList.add(nums[i]);
				permuteUnique(nums, currList, result, used);
				used[i] = false;
				currList.remove(currList.size() - 1);
			}
		}
	}
}
