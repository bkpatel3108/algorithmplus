package me.algo.leetcode;

public class Lc0342PowerofFour {
	public boolean isPowerOfFour(int num) {
		return Integer.bitCount(num) == 1 && (Integer.numberOfTrailingZeros(num) & 1) == 0;
	}
}
