package me.algo.leetcode;

public class Lc0141LinkedListCycle {
	public boolean hasCycle(ListNode head) {

		if (head == null)
			return false;

		if (head == head.next)
			return true;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}

		return false;
	}
}
