package me.algo.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IbLargestDistanceBetweenNodesOfATree {
	public int solve(int[] A) {
		Map<Integer, TreeNode> nodes = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			nodes.put(i, new TreeNode(i));
		}
		TreeNode root = null;

		for (int i = 0; i < A.length; i++) {
			if (A[i] != -1) {
				TreeNode node = nodes.get(A[i]);
				node.addChild(nodes.get(i));
			} else {
				root = nodes.get(i);
			}
		}
		height(root);
		System.out.println(root.height1 + " "+ root.height2);
		return findMaxPath(root);

	}

	int findMaxPath(TreeNode root) {
		int max = 0;
		max = Math.max(max, root.height1 + root.height2);
		for (TreeNode node : root.childs) {
			max = Math.max(max, findMaxPath(node));
		}

		return max;
	}

	void height(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.childs.size() == 0) {
			node.height1 = 0;
			node.height2 = 0;
			return;
		}

		int height1 = 0;
		int height2 = 0;
		for (TreeNode child : node.childs) {
			height(child);
			int height = 1 + child.height1;
			if (height >= height1) {
				height2 = height1;
				height1 = height;
			} else if (height > height2) {
				height2 = height;
			}
		}
		node.height1 = height1;
		node.height2 = height2;
	}

	class TreeNode {
		int val;
		List<TreeNode> childs;
		int height1;
		int height2;

		TreeNode(int val) {
			this.val = val;
			this.childs = new ArrayList<>();
		}

		void addChild(TreeNode child) {
			this.childs.add(child);
		}
	}

	public static void main(String[] args) {
		System.out.println(new IbLargestDistanceBetweenNodesOfATree().solve(new int[] { -1, 0, 0, 1, 2, 1, 5 }));
		System.out.println(new IbLargestDistanceBetweenNodesOfATree().solve(new int[] { -1, 0, 0, 0, 3 }));
	}

}
