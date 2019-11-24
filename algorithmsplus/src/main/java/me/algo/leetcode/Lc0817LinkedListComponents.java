package me.algo.leetcode;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lc0817LinkedListComponents {
	public int numComponents(ListNode head, int[] G) {
		if (head == null)
			return 0;
		Set<Integer> set = IntStream.of(G).boxed().collect(Collectors.toSet());
		int count = 0;
		boolean flag = true;
		while (head != null) {
			if (set.contains(head.val)) {
				if (flag) {
					count++;
					flag = false;
				}
			} else {
				flag = true;
			}
			head = head.next;
		}

		return count;
	}
}
