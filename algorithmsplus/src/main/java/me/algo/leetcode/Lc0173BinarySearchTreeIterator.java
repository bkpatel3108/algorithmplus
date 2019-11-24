package me.algo.leetcode;

import java.util.Stack;

public class Lc0173BinarySearchTreeIterator {
	private Stack<TreeNode> stack = new Stack<>();

	public Lc0173BinarySearchTreeIterator(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode topNode = stack.pop();
		TreeNode node = topNode.right;
		if (node != null) {
			stack.push(node);
			node = node.left;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return topNode.val;
	}
}
