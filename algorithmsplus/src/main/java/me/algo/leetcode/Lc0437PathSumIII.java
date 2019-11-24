package me.algo.leetcode;

public class Lc0437PathSumIII {
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		return pathSumRec(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	public int pathSumRec(TreeNode root, int sum) {

		if (root == null) {
			return 0;
		}

		int minPath = 0;
		if (root.val == sum) {
			minPath++;
		}

		minPath += pathSumRec(root.left, sum - root.val) + pathSumRec(root.right, sum - root.val);

		return minPath;
	}
}
