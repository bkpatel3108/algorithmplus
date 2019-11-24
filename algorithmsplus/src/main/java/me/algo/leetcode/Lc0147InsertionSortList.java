package me.algo.leetcode;

public class Lc0147InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode node = new ListNode(Integer.MIN_VALUE);
		node.next = head;
		head = node;

		ListNode i = head.next;
		ListNode pi = head;
		while (i != null) {
			ListNode pj = head;
			ListNode j = head.next;
			while (j != i) {
				if (j.val > i.val) {
					ListNode inext = i.next;
					pj.next = i;
					i.next = j;
					pi.next = inext;
					i = pi;
					break;
				}
				pj = j;
				j = j.next;
			}
			pi = i;
			i = i.next;
		}

		return head.next;
	}
}
