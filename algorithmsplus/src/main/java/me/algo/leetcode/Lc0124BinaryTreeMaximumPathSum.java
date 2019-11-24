package me.algo.leetcode;

public class Lc0124BinaryTreeMaximumPathSum {
	private Integer max;

	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		maxPathSumRec(root);
		return max;
	}

	public int maxPathSumRec(TreeNode node) {
		if (node == null)
			return 0;

		int leftCurrSum = Math.max(maxPathSumRec(node.left), 0);
		int rightCurrSum = Math.max(maxPathSumRec(node.right), 0);
		Integer currSum = Math.max(node.val + leftCurrSum, node.val + rightCurrSum);

		max = Math.max(node.val + leftCurrSum + rightCurrSum, max);

		return currSum;
	}
}
