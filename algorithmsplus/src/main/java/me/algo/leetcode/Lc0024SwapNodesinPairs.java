package me.algo.leetcode;

public class Lc0024SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode curr = new ListNode(0);
		curr.next = head;
		head = curr;
		while (curr.next != null && curr.next.next != null) {
			ListNode next = curr.next;
			ListNode secNext = next.next;
			next.next = secNext.next;
			curr.next = secNext;
			secNext.next = next;

			curr = next;
		}

		return head.next;
	}
}
