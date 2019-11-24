package me.algo.leetcode;

public class Lc0669TrimABinarySearchTree {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)
			return null;
		TreeNode newRoot = null;
		if (root.val >= L && root.val <= R) {
			newRoot = root;
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
		} else if (root.val <= L) {
			newRoot = trimBST(root.right, L, R);
		} else {
			newRoot = trimBST(root.left, L, R);
		}

		return newRoot;
	}
}
