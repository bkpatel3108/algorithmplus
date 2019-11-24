package me.algo.leetcode;

public class Lc0092ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode curr = head;
		ListNode first = head;
		int i = m;
		int len = n - m;
		while (i-- > 1) {
			first = curr;
			curr = curr.next;
		}
		ListNode secEnd = curr;
		ListNode pre = null;
		ListNode next = null;
		while (len-- >= 0) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		if (m == 1)
			head = pre;
		else
			first.next = pre;

		secEnd.next = curr;

		return head;
	}
}
