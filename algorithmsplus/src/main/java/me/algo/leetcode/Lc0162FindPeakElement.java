package me.algo.leetcode;

public class Lc0162FindPeakElement {
	public int findPeakElement(int[] nums) {
		return findPeakElementRec(nums, 0, nums.length - 1);
	}

	public int findPeakElementRec(int[] nums, int l, int r) {
		if (l == r)
			return l;
		else {
			int mid = (l + r) / 2;
			if (nums[mid] < nums[mid + 1])
				return findPeakElementRec(nums, mid + 1, r);
			else {
				return findPeakElementRec(nums, l, mid);
			}
		}
	}
}
