package me.algo.leetcode;

public class Lc109ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode prevSlow = null;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prevSlow = slow;
			slow = slow.next;
		}

		TreeNode root = new TreeNode(slow.val);
		if (prevSlow != null) {
			ListNode next = slow.next;
			prevSlow.next = null;
			root.left = sortedListToBST(head);
			root.right = sortedListToBST(next);
		}
		return root;
	}
}
