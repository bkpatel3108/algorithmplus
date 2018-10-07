package me.algo.leetcode;

public class Lc0061RotateList {
	public ListNode rotateRight(ListNode head, int k) {

		int length = getSize(head);

		if (head == null || length == 0 || k == 0 || k % length == 0)
			return head;

		ListNode firstEnd = getKthNode(head, length - (k % length));
		ListNode secondEnd = getKthNode(head, length);
		ListNode secondStart = firstEnd.next;
		firstEnd.next = null;
		secondEnd.next = head;
		return secondStart;
	}

	int getSize(ListNode node) {
		int length = 0;
		while (node != null) {
			node = node.next;
			length++;
		}
		return length;
	}

	ListNode getKthNode(ListNode node, int k) {
		while (--k > 0 && node != null) {
			node = node.next;
		}
		return node;
	}
}
