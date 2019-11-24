package me.algo.leetcode;

import java.util.PriorityQueue;

public class Lc0215KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
		for (int num : nums) {
			if (pq.size() <= k || num > pq.peek()) {
				pq.offer(num);
				if (pq.size() > k) {
					pq.poll();
				}
			}
		}

		return pq.poll();
	}
}
