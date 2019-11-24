package me.algo.leetcode;

public class Lc0083RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode currPtr = head.next;
		ListNode prePtr = head;
		ListNode unqPtr = head;

		while (currPtr != null) {
			if (currPtr.val != prePtr.val) {
				unqPtr.next = currPtr;
				unqPtr = currPtr;
			} else {
				unqPtr.next = null;
			}
			prePtr = currPtr;
			currPtr = currPtr.next;
		}

		return head;

	}
}
