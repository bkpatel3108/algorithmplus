package me.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc0105ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length)
			return null;
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < preorder.length; i++) {
			indexMap.put(preorder[i], i);
		}
		return buildTreeRec(indexMap, inorder, 0, inorder.length - 1);
	}

	public TreeNode buildTreeRec(Map<Integer, Integer> indexMap, int[] inorder, int l, int r) {
		if (l > r) {
			return null;
		}
		int preMinIndex = Integer.MAX_VALUE;
		int inMinIndex = l;
		for (int i = l; i <= r; i++) {
			if (indexMap.get(inorder[i]) < preMinIndex) {
				preMinIndex = indexMap.get(inorder[i]);
				inMinIndex = i;
			}
		}
		TreeNode root = new TreeNode(inorder[inMinIndex]);
		root.left = buildTreeRec(indexMap, inorder, l, inMinIndex - 1);
		root.right = buildTreeRec(indexMap, inorder, inMinIndex + 1, r);

		return root;

	}
}
