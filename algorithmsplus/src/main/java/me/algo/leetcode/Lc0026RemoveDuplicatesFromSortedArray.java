package me.algo.leetcode;

public class Lc0026RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null)
			return -1;
		if (nums.length <= 1)
			return nums.length;

		int f = 0;
		int s = 1;
		while (s < nums.length) {
			if (nums[f] != nums[s]) {
				nums[f + 1] = nums[s];
				f++;
			}
			s++;
		}
		return f + 1;
	}
}
