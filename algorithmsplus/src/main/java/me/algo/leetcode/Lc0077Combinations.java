package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0077Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		combineBacktrack(n, k, 1, new ArrayList<Integer>(), list);
		return list;
	}

	public void combineBacktrack(int n, int k, int start, List<Integer> tempList, List<List<Integer>> list) {
		if (tempList.size() == k) {
			list.add(new ArrayList(tempList));
			return;
		}

		for (int i = start; i <= n; i++) {
			tempList.add(i);
			combineBacktrack(n, k, i + 1, tempList, list);
			tempList.remove(tempList.size() - 1);
		}
	}
}
