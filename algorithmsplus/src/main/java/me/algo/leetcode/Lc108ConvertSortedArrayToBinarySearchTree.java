package me.algo.leetcode;

public class Lc108ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
		if (l > r)
			return null;
		int mid = (l + r) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBST(nums, l, mid - 1);
		node.right = sortedArrayToBST(nums, mid + 1, r);
		return node;
	}
}
