package me.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Lc0933NumberOfRecentCalls {
	Queue<Integer> q;

	public Lc0933NumberOfRecentCalls() {
		q = new LinkedList<>();
	}

	public int ping(int t) {
		q.offer(t);
		while (t - q.peek() > 3000) {
			q.poll();
		}
		return q.size();
	}
}
