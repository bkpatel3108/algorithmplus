package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0199BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		rightSideView(root, 0, list);
		return list;
	}

	public void rightSideView(TreeNode node, int level, List<Integer> list) {
		if (node == null)
			return;
		if (level >= list.size()) {
			list.add(node.val);
		}
		rightSideView(node.right, level + 1, list);
		rightSideView(node.left, level + 1, list);
	}
}
