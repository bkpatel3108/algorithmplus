package me.algo.leetcode;

public class Lc0143ReorderList {
	public void reorderList(ListNode head) {
		if (head == null)
			return;

		ListNode preMidNode = head;
		ListNode midNode = head;
		int length = getLength(head);
		int reverseStart = 0;
		if (length % 2 == 0) {
			reverseStart = length / 2;
		} else {
			reverseStart = length / 2 + 1;
		}
		for (int i = 0; i < reverseStart; i++) {
			preMidNode = midNode;
			midNode = midNode.next;
		}
		preMidNode.next = null;
		ListNode reversedListStartNode = reverseLinkedList(midNode);
		ListNode listStartNode = head;
		while (listStartNode != null) {
			ListNode listStartNodeNext = listStartNode.next;
			listStartNode.next = reversedListStartNode;
			ListNode reversedListStartNodeNext = null;
			if (reversedListStartNode != null) {
				reversedListStartNodeNext = reversedListStartNode.next;
				reversedListStartNode.next = listStartNodeNext;
			}

			listStartNode = listStartNodeNext;
			reversedListStartNode = reversedListStartNodeNext;
		}
	}

	private int getLength(ListNode node) {
		int length = 0;
		while (node != null) {
			node = node.next;
			length++;
		}
		return length;
	}

	private ListNode reverseLinkedList(ListNode node) {
		if (node == null)
			return null;
		ListNode pre = null;
		ListNode curr = node;
		ListNode next = node.next;

		while (curr != null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}

		return pre;
	}
}
