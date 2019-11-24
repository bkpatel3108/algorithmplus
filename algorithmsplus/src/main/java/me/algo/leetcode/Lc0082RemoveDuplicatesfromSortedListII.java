package me.algo.leetcode;

public class Lc0082RemoveDuplicatesfromSortedListII {
	// approch2: in-place solution, delete from original list
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode curr = head;
		ListNode resultHead = null;
		ListNode resultCurr = null;
		boolean flag = false;
		while (curr != null) {
			if (curr.next != null && curr.val == curr.next.val) {
				flag = true;
				if (resultCurr != null)
					resultCurr.next = null;
			} else {
				if (flag == false) {
					if (resultCurr == null) {
						resultHead = curr;
						resultCurr = resultHead;
					} else {
						resultCurr.next = curr;
						resultCurr = resultCurr.next;
					}
				} else
					flag = false;
			}
			curr = curr.next;
		}
		return resultHead;
	}
}
