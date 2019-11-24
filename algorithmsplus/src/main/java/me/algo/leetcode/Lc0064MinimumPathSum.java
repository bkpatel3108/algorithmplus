package me.algo.leetcode;

import java.util.Arrays;

public class Lc0064MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int[][] memo = new int[grid.length][grid[0].length];
		for (int[] row : memo)
			Arrays.fill(row, -1);
		return minPathSumRec(grid, memo, grid.length - 1, grid[0].length - 1);
	}

	public int minPathSumRec(int[][] grid, int memo[][], int r, int c) {
		if (r < 0 || c < 0)
			return -1;

		if (memo[r][c] != -1)
			return memo[r][c];

		if (r == 0 && c == 0) {
			memo[r][c] = grid[0][0];
			return grid[0][0];
		}

		int minPath = grid[r][c];
		int leftMinPath = minPathSumRec(grid, memo, r - 1, c);
		int rightMinPath = minPathSumRec(grid, memo, r, c - 1);
		if (leftMinPath != -1 && rightMinPath != -1)
			minPath = minPath + Math.min(leftMinPath, rightMinPath);
		else if (leftMinPath == -1)
			minPath = minPath + rightMinPath;
		else
			minPath = minPath + leftMinPath;

		memo[r][c] = minPath;
		return minPath;
	}
}
