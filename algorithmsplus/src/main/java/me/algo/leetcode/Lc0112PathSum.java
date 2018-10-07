package me.algo.leetcode;

public class Lc0112PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		return hasPathSum(root, sum, 0);
	}

	public boolean hasPathSum(TreeNode node, int sum, int currSum) {
		if (node == null)
			return false;
		if (isLeafNode(node)) {
			if ((node.val + currSum) == sum)
				return true;
			return false;
		}
		return hasPathSum(node.left, sum, node.val + currSum) || hasPathSum(node.right, sum, node.val + currSum);
	}

	boolean isLeafNode(TreeNode node) {
		if (node.left == null && node.right == null)
			return true;
		return false;
	}
}
