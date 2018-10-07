package me.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc0102BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		LinkedList<TreeNode> currentQueue = new LinkedList<TreeNode>();
		LinkedList<TreeNode> nextQueue = new LinkedList<TreeNode>();
		List<Integer> level = new ArrayList<Integer>();
		if (root != null) {
			currentQueue.addLast(root);
		}
		while (!currentQueue.isEmpty()) {
			TreeNode currNode = currentQueue.removeFirst();
			level.add(currNode.val);
			if (currNode.left != null)
				nextQueue.addLast(currNode.left);
			if (currNode.right != null)
				nextQueue.addLast(currNode.right);

			if (currentQueue.isEmpty()) {
				currentQueue = nextQueue;
				nextQueue = new LinkedList<TreeNode>();
				finalList.add(level);
				level = new ArrayList<Integer>();
			}
		}
		return finalList;
	}
}
