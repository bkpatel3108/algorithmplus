package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc0145BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> post = new ArrayList<Integer>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.peek();
				if (curr.right != null && (post.size() == 0 || curr.right.val != post.get(post.size() - 1))) {
					curr = curr.right;
				} else {
					post.add(stack.pop().val);
					curr = null;
				}
			}
		}
		return post;
	}
}
