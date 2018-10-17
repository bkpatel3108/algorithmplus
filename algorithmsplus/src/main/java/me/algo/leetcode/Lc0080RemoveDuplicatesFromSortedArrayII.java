package me.algo.leetcode;

public class Lc0080RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length <= 2)
			return nums.length;
		int j = 1;
		for (int i = 1, cl = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i]) {
				cl++;
				if (cl <= 2) {
					nums[j++] = nums[i];
				}
			} else {
				cl = 1;
				nums[j++] = nums[i];
			}
		}

		return j;
	}
}
