package me.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Lc0106ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
		IntStream.range(0, inorder.length).forEach(i -> inorderMap.put(inorder[i], i));
		return buildTree(inorder, postorder, inorderMap, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer, Integer> inorderMap, int li, int ri, int lp,
			int rp) {
		// base conditions
		if (li > ri || lp > rp)
			return null;

		int index = inorderMap.get(postorder[rp]);
		TreeNode node = new TreeNode(postorder[rp]);

		node.left = buildTree(inorder, postorder, inorderMap, li, index - 1, lp, lp + ((index - 1) - li));
		node.right = buildTree(inorder, postorder, inorderMap, index + 1, ri, lp + ((index - 1) - li) + 1, rp - 1);

		return node;
	}
}
