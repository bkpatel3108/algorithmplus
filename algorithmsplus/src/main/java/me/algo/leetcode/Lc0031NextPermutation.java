package me.algo.leetcode;

public class Lc0031NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		if (nums.length == 2) {
			reverse(nums, 0);
			return;
		}

		// find the first index in array where previous element is less then
		// current element
		int i = nums.length - 1;
		while (i > 0) {
			if (nums[i - 1] < nums[i]) {
				break;
			}
			i--;
		}
		i--;

		// if no previous element is found then just reverse the array and
		// return it
		if (i == -1) {
			reverse(nums, 0);
			return;
		}

		// find the element in right of i which is greater that nums[i] and
		// smallest in that group
		int j = i + 1;
		int minIndex = j;
		while (j < nums.length) {
			if (nums[j] > nums[i] && nums[j] <= nums[minIndex])
				minIndex = j;
			j++;
		}

		// swap i with j
		swap(nums, i, minIndex);

		// reverse elements from i+1 to nums.length-1 as they will be in reverse
		// sorted.
		reverse(nums, i + 1);
	}

	public void reverse(int[] nums, int indexFromLast) {
		int i = indexFromLast;
		int j = nums.length - 1;

		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}

	}

	public void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}
