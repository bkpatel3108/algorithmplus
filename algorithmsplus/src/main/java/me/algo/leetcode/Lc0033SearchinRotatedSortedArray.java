package me.algo.leetcode;

public class Lc0033SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	public int binarySearch(int[] nums, int target, int left, int right) {
		if (left > right)
			return -1;
		int index = -1;
		int mid = (left + right) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if ((nums[left] < nums[mid] && target >= nums[left] && target <= nums[mid]) || nums[left] >= nums[mid]) {
			index = binarySearch(nums, target, left, mid - 1);
		}
		if (index == -1 && ((nums[right] > nums[mid] && target >= nums[mid] && target <= nums[right])
				|| nums[right] <= nums[mid])) {
			index = binarySearch(nums, target, mid + 1, right);
		}
		return index;
	}
}
