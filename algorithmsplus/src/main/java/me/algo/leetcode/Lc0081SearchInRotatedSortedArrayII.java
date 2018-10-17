package me.algo.leetcode;

public class Lc0081SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		return searchRec(nums, target, 0, nums.length - 1);
	}

	public boolean searchRec(int[] nums, int target, int l, int r) {
		if (l > r)
			return false;

		int mid = (l + r) / 2;

		if (nums[mid] == target)
			return true;
		else {
			boolean flag = false;
			if (nums[l] >= nums[mid] || (target < nums[mid] && target >= nums[l]))
				flag = flag || searchRec(nums, target, l, mid - 1);
			if (flag == false && (nums[r] <= nums[mid] || (target > nums[mid] && target <= nums[r])))
				flag = flag || searchRec(nums, target, mid + 1, r);
			return flag;
		}
	}
}
