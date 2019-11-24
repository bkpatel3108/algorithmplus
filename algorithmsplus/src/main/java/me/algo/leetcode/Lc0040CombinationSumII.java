package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc0040CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		combinationSumBacktrack(candidates, result, new ArrayList<Integer>(), target, 0);
		return result;
	}

	public void combinationSumBacktrack(int[] candidates, List<List<Integer>> result, List<Integer> tempList,
			int target, int start) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			result.add(new ArrayList<Integer>(tempList));
		} else {
			for (int i = start; i < candidates.length; i++) {
				if (i > start && candidates[i] == candidates[i - 1]) {
					continue;
				}
				tempList.add(candidates[i]);
				combinationSumBacktrack(candidates, result, tempList, target - candidates[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
