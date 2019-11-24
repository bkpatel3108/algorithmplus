package me.algo.leetcode;

public class Lc0111MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int minDepth = 0;
		int leftMinDepth = minDepth(root.left);
		int rightMinDepth = minDepth(root.right);
		if (leftMinDepth == 0)
			minDepth = rightMinDepth;
		else if (rightMinDepth == 0)
			minDepth = leftMinDepth;
		else
			minDepth = Math.min(leftMinDepth, rightMinDepth);

		return 1 + minDepth;
	}
}
