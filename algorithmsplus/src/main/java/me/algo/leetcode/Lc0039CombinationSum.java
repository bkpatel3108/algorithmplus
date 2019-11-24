package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0039CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combinationSumBacktrack(candidates, target, 0, result, new ArrayList<Integer>());
		return result;
	}

	public void combinationSumBacktrack(int[] candidates, int target, int start, List<List<Integer>> result,
			List<Integer> tempList) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			result.add(new ArrayList<Integer>(tempList));
		} else {
			for (int i = start; i < candidates.length; i++) {
				tempList.add(candidates[i]);
				combinationSumBacktrack(candidates, target - candidates[i], i, result, tempList);
				tempList.remove(tempList.size() - 1);
			}
		}

	}
}
