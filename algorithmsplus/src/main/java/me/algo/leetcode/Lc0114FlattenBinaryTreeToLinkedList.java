package me.algo.leetcode;

public class Lc0114FlattenBinaryTreeToLinkedList {
	// basic O(n^2) solution
	// public void flatten(TreeNode root) {
	// if(root == null)
	// return;
	// TreeNode right = root.right;
	// if(root.left != null){
	// root.right = root.left;
	// flatten(root.left);
	// root.left = null;
	// while(root.right != null)
	// root = root.right;
	// }
	// root.right = right;
	// flatten(right);
	// }

	// imporoved O(n) solution
	// we can elminate while loop. for that we need to return lastnode generated
	// by each flatten iteration.
	// lets use helper method to return lastnode after flatten gets applied

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flattenAndReturnLastNode(root);
	}

	public TreeNode flattenAndReturnLastNode(TreeNode root) {
		if (root.left == null && root.right == null)
			return root;

		TreeNode lastNode = root;
		TreeNode right = root.right;
		if (root.left != null) {
			root.right = root.left;
			lastNode = flattenAndReturnLastNode(root.left);
			root.left = null;
		}

		if (right != null) {
			lastNode.right = right;
			lastNode = flattenAndReturnLastNode(right);
		}

		return lastNode;
	}
}
