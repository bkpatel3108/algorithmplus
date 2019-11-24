package me.algo.leetcode;

public class Lc0027RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums == null)
			return -1;
		if (nums.length == 0)
			return 0;
		int f = 0;
		int s = 0;
		while (s < nums.length) {
			if (nums[s] != val)
				nums[f++] = nums[s++];
			else
				s++;
		}
		return f;
	}
}
