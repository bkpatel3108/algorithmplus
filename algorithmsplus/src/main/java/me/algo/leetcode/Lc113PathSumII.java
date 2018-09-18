package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc113PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root != null) {
			pathSum(root, sum, result, new ArrayList<Integer>(Arrays.asList(root.val)));
		}
		return result;
	}

	private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> currList) {
		if (root.left == null && root.right == null && root.val == sum) {
			result.add(new ArrayList<Integer>(currList));
		}

		if (root.left != null) {
			currList.add(root.left.val);
			pathSum(root.left, sum - root.val, result, currList);
			currList.remove(currList.size() - 1);
		}

		if (root.right != null) {
			currList.add(root.right.val);
			pathSum(root.right, sum - root.val, result, currList);
			currList.remove(currList.size() - 1);
		}
	}
}
