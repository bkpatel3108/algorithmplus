package me.algo.leetcode;

public class Lc0136SingleNumber {
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int n : nums) {
			result = result ^ n;
		}
		return result;
	}
}
