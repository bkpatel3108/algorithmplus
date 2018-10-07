package me.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Lc0107BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<>();
		if (root == null)
			return result;
		LinkedList<TreeNode> currLvl = new LinkedList<>();
		LinkedList<TreeNode> nextLvl = new LinkedList<>();
		currLvl.addLast(root);
		LinkedList<Integer> list = new LinkedList<>();

		while (currLvl.size() > 0) {
			TreeNode node = currLvl.removeFirst();
			list.addLast(node.val);

			if (node.left != null) {
				nextLvl.addLast(node.left);
			}

			if (node.right != null) {
				nextLvl.addLast(node.right);
			}

			if (currLvl.size() == 0) {
				result.addFirst(list);
				list = new LinkedList<>();
				currLvl = nextLvl;
				nextLvl = new LinkedList<>();
			}
		}

		return result;
	}
}
