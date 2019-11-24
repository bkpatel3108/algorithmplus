package me.algo.leetcode;

public class Lc0129SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}

	public int sumNumbers(TreeNode node, int currVal) {
		if (node == null)
			return 0;
		currVal = currVal * 10 + node.val;
		if (isLeaf(node)) {
			return currVal;
		}
		return sumNumbers(node.left, currVal) + sumNumbers(node.right, currVal);
	}

	public boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null ? true : false;
	}
}
