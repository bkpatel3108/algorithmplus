package me.algo.leetcode;

public class Lc0098ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;

		return (min == null || root.val > min) && (max == null || root.val < max)
				&& isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
}
