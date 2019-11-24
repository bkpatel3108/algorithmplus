package me.algo.leetcode;

public class Lc0055JumpGame {
	// DP Solution
	// Boolean[] memo;

	// public boolean canJump(int[] nums) {
	// memo = new Boolean[nums.length];
	// System.out.println(memo);
	// return canJumpFromGivenIndex(0, nums);
	// }

	// private boolean canJumpFromGivenIndex(int index, int[] nums) {
	// if (index == nums.length - 1) {
	// return true;
	// }
	// for (int i = 1; i <= nums[index]; i++) {
	// boolean canReach = memo[index + i] != null
	// ? memo[index + i]
	// : canJumpFromGivenIndex(index + i, nums);
	// memo[index + i] = canReach;
	// if (canReach == true)
	// return true;
	// }
	// return false;
	// }

	public boolean canJump(int[] nums) {
		if (nums == null || nums.length <= 1)
			return true;

		int maxReach = nums[0];

		for (int i = 1; i <= maxReach; i++) {
			if (maxReach >= nums.length - 1) {
				return true;
			} else {
				maxReach = Math.max(maxReach, i + nums[i]);
			}
		}
		return false;
	}
}
