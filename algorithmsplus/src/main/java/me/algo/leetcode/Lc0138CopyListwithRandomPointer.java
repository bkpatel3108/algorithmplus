package me.algo.leetcode;

public class Lc0138CopyListwithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {

		if (head == null)
			return null;

		// copy each node to next to it.
		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode next = curr.next;
			RandomListNode node = new RandomListNode(curr.label);
			curr.next = node;
			node.next = next;
			curr = next;
		}

		// copy random pointers
		curr = head;
		while (curr != null && curr.next != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}

		// detach copy linkedlist from main linkedlist
		RandomListNode firstHead = head;
		RandomListNode secondHead = head.next;
		RandomListNode first = firstHead;
		RandomListNode second = secondHead;
		while (second != null) {
			first.next = first.next.next;
			first = first.next;
			if (second.next != null)
				second.next = second.next.next;
			else
				break;
			second = second.next;
		}

		return secondHead;
	}
}
