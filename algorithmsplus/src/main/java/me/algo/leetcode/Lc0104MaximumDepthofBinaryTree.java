package me.algo.leetcode;

public class Lc0104MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		int leftMaxDepth = 0, rightMaxDepth = 0;
		if (root.left != null)
			leftMaxDepth = maxDepth(root.left);
		if (root.right != null)
			rightMaxDepth = maxDepth(root.right);

		return 1 + Math.max(leftMaxDepth, rightMaxDepth);

	}
}
