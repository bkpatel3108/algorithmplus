package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0046Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		permuteBacktrack(nums, new ArrayList<Integer>(), result, used);
		return result;
	}

	public void permuteBacktrack(int[] nums, List<Integer> currList, List<List<Integer>> result, boolean[] used) {
		if (currList.size() == nums.length) {
			result.add(new ArrayList<Integer>(currList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				currList.add(nums[i]);
				permuteBacktrack(nums, currList, result, used);
				currList.remove(currList.size() - 1);
				used[i] = false;
			}
		}
	}
}
