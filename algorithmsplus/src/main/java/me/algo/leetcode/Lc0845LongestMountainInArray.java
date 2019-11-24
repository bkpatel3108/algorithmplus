package me.algo.leetcode;

public class Lc0845LongestMountainInArray {
	public int longestMountain(int[] A) {
		int incr = 0;
		int incrDecr = 0;
		int max = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1]) {
				incr++;
				incrDecr = 0;
			} else if (A[i] < A[i - 1]) {
				if (incr >= 1) {
					incrDecr = incr + 1;
					incr = 0;
				} else if (incrDecr >= 1) {
					incrDecr++;
					incr = 0;
				} else {
					incr = 0;
					incrDecr = 0;
				}
			} else {
				incr = 0;
				incrDecr = 0;
			}

			max = Math.max(max, incrDecr);
		}

		return max >= 2 ? max + 1 : 0;
	}
}
