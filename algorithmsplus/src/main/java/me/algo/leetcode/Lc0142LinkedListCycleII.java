package me.algo.leetcode;

public class Lc0142LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			if (slow == fast)
				break;
			slow = slow.next;
			fast = fast.next.next;
		}

		// count no of element in cycle
		int cnt = 1;
		if (slow == fast) {
			ListNode node = fast.next;
			while (node != fast) {
				node = node.next;
				cnt++;
			}

			ListNode node1 = head;
			ListNode node2 = head;
			while (cnt-- > 0)
				node2 = node2.next;

			while (node1 != node2) {
				node1 = node1.next;
				node2 = node2.next;
			}

			return node1;
		}

		return null;
	}
}
