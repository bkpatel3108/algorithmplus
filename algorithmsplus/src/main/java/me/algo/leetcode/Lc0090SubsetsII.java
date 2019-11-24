package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc0090SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		subsetsWithDup(nums, result, new ArrayList<Integer>(), 0);
		return result;
	}

	public void subsetsWithDup(int[] nums, List<List<Integer>> result, List<Integer> tempList, int start) {
		result.add(new ArrayList(tempList));

		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue;
			tempList.add(nums[i]);
			subsetsWithDup(nums, result, tempList, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
