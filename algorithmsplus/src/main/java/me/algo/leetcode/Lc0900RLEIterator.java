package me.algo.leetcode;

public class Lc0900RLEIterator {
	int[] A;
	int curr;

	public Lc0900RLEIterator(int[] A) {
		this.A = A;
		this.curr = 0;
	}

	public int next(int n) {
		int lastTerm = -1;
		while (n > 0) {
			if (curr == A.length)
				return -1;
			int currCapacity = A[curr];
			if (n > currCapacity) {
				n = n - currCapacity;
				curr = curr + 2;
			} else {
				A[curr] = currCapacity - n;
				lastTerm = A[curr + 1];
				n = 0;
			}
		}
		return lastTerm;
	}
}
