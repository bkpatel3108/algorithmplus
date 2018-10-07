package me.algo.leetcode;

public class Lc0034FindFirstandLastPositionofElementinSortedArray {
	public int[] searchRange(int[] nums, int target) {
		int start = binarySearchLeftMost(nums, target, 0, nums.length - 1);
		int end = binarySearchRightMost(nums, target, 0, nums.length - 1);
		return new int[] { start, end };
	}

	public int binarySearchLeftMost(int[] nums, int target, int l, int r) {
		if (l > r)
			return -1;

		int mid = (l + r) / 2;

		if (nums[mid] == target) {
			if (mid > 0 && nums[mid - 1] == target) {
				return binarySearchLeftMost(nums, target, l, mid - 1);
			} else {
				return mid;
			}
		} else if (target < nums[mid]) {
			return binarySearchLeftMost(nums, target, l, mid - 1);
		} else {
			return binarySearchLeftMost(nums, target, mid + 1, r);
		}
	}

	public int binarySearchRightMost(int[] nums, int target, int l, int r) {
		if (l > r)
			return -1;

		int mid = (l + r) / 2;

		if (nums[mid] == target) {
			if (mid < nums.length - 1 && nums[mid + 1] == target) {
				return binarySearchRightMost(nums, target, mid + 1, r);
			} else {
				return mid;
			}
		} else if (target < nums[mid]) {
			return binarySearchRightMost(nums, target, l, mid - 1);
		} else {
			return binarySearchRightMost(nums, target, mid + 1, r);
		}
	}

	// Another way of thinking
	public int[] searchRange1(int[] nums, int target) {
		int targetIndex = binarySearch(nums, target, 0, nums.length - 1);
		if (targetIndex == -1) {
			return new int[] { -1, -1 };
		}
		int start = targetIndex;
		int end = targetIndex;
		while (start > 0 && nums[start - 1] == target) {
			start = binarySearch(nums, target, 0, start - 1);
		}
		while (end < nums.length - 1 && nums[end + 1] == target) {
			end = binarySearch(nums, target, end + 1, nums.length - 1);
		}
		return new int[] { start, end };
	}

	public int binarySearch(int[] nums, int target, int l, int r) {
		if (l > r)
			return -1;

		int mid = (l + r) / 2;

		if (nums[mid] == target) {
			return mid;
		} else if (target < nums[mid]) {
			return binarySearch(nums, target, l, mid - 1);
		} else {
			return binarySearch(nums, target, mid + 1, r);
		}
	}
}
