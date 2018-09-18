package me.algo.leetcode;

import java.util.Arrays;

public class Lc63UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] table = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
		for (int[] row : table) {
			Arrays.fill(row, 0);
		}
		if (obstacleGrid[0][0] == 1) {
			return 0;
		} else {
			table[1][1] = 1;
		}

		for (int i = 1; i < obstacleGrid.length + 1; i++) {
			for (int j = 1; j < obstacleGrid[0].length + 1; j++) {
				if (i == 1 && j == 1)
					continue;
				if (obstacleGrid[i - 1][j - 1] == 1) {
					table[i][j] = 0;
				} else {
					table[i][j] = table[i - 1][j] + table[i][j - 1];
				}
			}
		}

		return table[obstacleGrid.length][obstacleGrid[0].length];
	}

	public int uniquePathsWithObstaclesRec(int[][] obstacleGrid) {
		int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
		for (int[] row : memo)
			Arrays.fill(row, -1);
		return uniquePathsWithObstaclesRec(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, memo);
	}

	public int uniquePathsWithObstaclesRec(int[][] obstacleGrid, int r, int c, int[][] memo) {
		if (r == 0 && c == 0) {
			return obstacleGrid[0][0] == 0 ? 1 : 0;
		}
		if (r < 0 || c < 0) {
			return 0;
		}
		if (obstacleGrid[r][c] == 1) {
			return 0;
		}
		if (memo[r][c] != -1) {
			return memo[r][c];
		}

		int noOfPaths = 0;
		noOfPaths = uniquePathsWithObstaclesRec(obstacleGrid, r - 1, c, memo)
				+ uniquePathsWithObstaclesRec(obstacleGrid, r, c - 1, memo);

		memo[r][c] = noOfPaths;
		return noOfPaths;
	}
}
