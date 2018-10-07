package me.algo.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lc0023MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		ListNode head = new ListNode(0);
		ListNode curr = head;
		Queue<ListNode> heap = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
		for (ListNode node : lists) {
			if (node != null)
				heap.offer(node);
		}
		while (!heap.isEmpty()) {
			ListNode min = heap.poll();
			curr.next = min;
			curr = curr.next;
			if (min.next != null)
				heap.offer(min.next);
		}
		return head.next;
	}
}
