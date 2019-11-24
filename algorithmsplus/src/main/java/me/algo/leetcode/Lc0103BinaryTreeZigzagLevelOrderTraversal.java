package me.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc0103BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		LinkedList<TreeNode> currLevelList = new LinkedList<TreeNode>();
		LinkedList<TreeNode> nextLevelList = new LinkedList<TreeNode>();
		List<Integer> level = new ArrayList<Integer>();
		if (root != null)
			currLevelList.addLast(root);
		int cntLevel = 0;
		while (!currLevelList.isEmpty()) {
			TreeNode currNode = currLevelList.removeLast();
			level.add(currNode.val);
			if (cntLevel % 2 == 0) {
				if (currNode.left != null)
					nextLevelList.addLast(currNode.left);
				if (currNode.right != null)
					nextLevelList.addLast(currNode.right);
			} else {
				if (currNode.right != null)
					nextLevelList.addLast(currNode.right);
				if (currNode.left != null)
					nextLevelList.addLast(currNode.left);
			}
			if (currLevelList.isEmpty()) {
				cntLevel++;
				finalList.add(level);
				currLevelList = nextLevelList;
				nextLevelList = new LinkedList<TreeNode>();
				level = new ArrayList<Integer>();
			}

		}
		return finalList;
	}
}
