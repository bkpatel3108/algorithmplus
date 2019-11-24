package me.algo.leetcode;

import java.util.Arrays;

public class Lc0908SmallestRangeI {
	public int smallestRangeI(int[] A, int K) {
		int min = Arrays.stream(A).min().getAsInt() + K;
		int max = Arrays.stream(A).max().getAsInt() - K;

		if (min > max)
			return 0;
		return max - min;
	}
}
