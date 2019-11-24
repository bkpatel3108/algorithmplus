package me.algo.leetcode;

public class Lc0671SecondMinimumNodeInABinaryTree {
	public int findSecondMinimumValue(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int leftMin = getMin(root.left, root.val);
		int rightMin = getMin(root.right, root.val);

		int secondMin = Math.min(leftMin, rightMin);
		return secondMin != Integer.MAX_VALUE ? secondMin : -1;
	}

	public int getMin(TreeNode root, int val) {
		if (root == null)
			return Integer.MAX_VALUE;

		int min = Math.min(getMin(root.left, val), getMin(root.right, val));
		if (root.val != val)
			min = Math.min(root.val, min);

		return min;
	}
}
