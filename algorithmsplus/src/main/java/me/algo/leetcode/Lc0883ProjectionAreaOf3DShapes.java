package me.algo.leetcode;

public class Lc0883ProjectionAreaOf3DShapes {
	public int projectionArea(int[][] grid) {
		int top = 0;
		int side1 = 0;
		int side2 = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > 0)
					top++;
			}
		}

		for (int i = 0; i < grid.length; i++) {
			int maxInRow = 0;
			for (int j = 0; j < grid[0].length; j++) {
				maxInRow = Math.max(maxInRow, grid[i][j]);
			}
			side1 += maxInRow;
		}

		for (int j = 0; j < grid[0].length; j++) {
			int maxInCol = 0;
			for (int i = 0; i < grid.length; i++) {
				maxInCol = Math.max(maxInCol, grid[i][j]);
			}
			side2 += maxInCol;
		}

		return top + side1 + side2;
	}
}
