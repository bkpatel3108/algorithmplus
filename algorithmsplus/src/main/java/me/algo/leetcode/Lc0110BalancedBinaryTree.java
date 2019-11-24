package me.algo.leetcode;

public class Lc0110BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		int height = height(root);
		if (height == -1)
			return false;
		return true;
	}

	private int height(TreeNode node) {
		if (node == null)
			return 0;
		int leftTreeHeight = height(node.left);
		int rightTreeHeight = height(node.right);

		if (leftTreeHeight < 0 || rightTreeHeight < 0 || Math.abs(leftTreeHeight - rightTreeHeight) > 1)
			return -1;

		return 1 + Math.max(leftTreeHeight, rightTreeHeight);

	}
}
