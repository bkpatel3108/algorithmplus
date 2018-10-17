package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lc0094BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;

		// Pre order

		// while(curr != null || !stack.isEmpty()){
		// if(curr == null)
		// curr = stack.pop();
		// inorder.add(curr.val);
		// if(curr.right != null)
		// stack.push(curr.right);
		// curr = curr.left;
		// }

		// In order

		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop();
				inorder.add(curr.val);
				curr = curr.right;
			}
		}
		return inorder;
	}
}
