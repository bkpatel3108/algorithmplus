package me.algo.leetcode;

public class Lc0096UniqueBinarySearchTrees {
	public int numTrees(int n) {
		int[] memo = new int[n + 1];
		memo[0] = memo[1] = 1;
		int ans = numTreesRec(n, memo);
		return ans;
	}

	public int numTreesRec(int n, int[] memo) {
		if (memo[n] != 0)
			return memo[n];

		for (int i = 0; i < n; i++)
			memo[n] = memo[n] + (numTreesRec(i, memo) * numTreesRec(n - (i + 1), memo));

		return memo[n];
	}
}
