package me.algo.leetcode;

public class Lc0019RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;

		ListNode fstPtr = head;
		ListNode secPtr = head;

		while (n-- > 0)
			secPtr = secPtr.next;

		if (secPtr == null)
			return head.next;

		while (secPtr.next != null) {
			fstPtr = fstPtr.next;
			secPtr = secPtr.next;
		}

		fstPtr.next = fstPtr.next.next;

		return head;
	}
}
