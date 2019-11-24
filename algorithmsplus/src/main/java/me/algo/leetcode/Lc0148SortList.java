package me.algo.leetcode;

public class Lc0148SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode fast = head;
		ListNode slow = head;
		ListNode preSlow = null;

		while (fast != null && fast.next != null) {
			preSlow = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode next = preSlow.next;
		preSlow.next = null;
		ListNode first = sortList(head);
		ListNode second = sortList(next);

		return merge(first, second);
	}

	public ListNode merge(ListNode first, ListNode second) {
		ListNode mergeHead = new ListNode(0);
		ListNode merge = mergeHead;
		while (first != null || second != null) {
			if (first != null && second != null) {
				if (first.val < second.val) {
					merge.next = first;
					first = first.next;
				} else {
					merge.next = second;
					second = second.next;
				}
			} else if (first != null) {
				merge.next = first;
				first = first.next;
			} else {
				merge.next = second;
				second = second.next;
			}
			merge = merge.next;
		}
		return mergeHead.next;
	}
}
