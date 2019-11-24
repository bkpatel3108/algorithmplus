package me.algo.leetcode;

public class Lc0075SortColors {
	public void sortColors(int[] nums) {
		int li = 0, lj = 0;
		int ri = nums.length - 1, rj = nums.length - 1;

		while (lj <= rj) {
			// if lj == 2 and rj == 0 swap them
			if (nums[lj] == 2 && nums[rj] == 0) {
				swap(nums, lj, rj);
			}

			// if lj == 0 then move it to left
			// if lj == 1 increment ptr
			if (nums[lj] == 0) {
				swap(nums, li, lj);
				lj++;
				li++;
			} else if (nums[lj] == 1)
				lj++;

			// if rj == 2 then move it to right
			// if rj == 1 decrement ptr
			if (nums[rj] == 2) {
				swap(nums, ri, rj);
				ri--;
				rj--;
			} else if (nums[rj] == 1)
				rj--;
		}

	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
