package me.algo.leetcode;

public class Lc0035SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {

		if (target > nums[nums.length - 1])
			return nums.length;

		return binarySearch(nums, target, 0, nums.length - 1);
	}

	int binarySearch(int[] nums, int target, int l, int r) {
		if (l > r) {
			return l;
		}

		int mid = (l + r) / 2;

		if (target == nums[mid]) {
			return mid;
		} else if (target < nums[mid]) {
			return binarySearch(nums, target, l, mid - 1);
		} else {
			return binarySearch(nums, target, mid + 1, r);
		}
	}
}
