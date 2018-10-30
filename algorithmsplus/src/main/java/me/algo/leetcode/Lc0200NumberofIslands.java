package me.algo.leetcode;

public class Lc0200NumberofIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int noOfIslands = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && visited[i][j] == false) {
					numIslandsRec(grid, i, j, visited);
					noOfIslands++;
				}
			}
		}
		return noOfIslands;
	}

	public void numIslandsRec(char[][] grid, int i, int j, boolean[][] visited) {
		if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0' || visited[i][j] == true)
			return;
		visited[i][j] = true;
		numIslandsRec(grid, i - 1, j, visited);
		numIslandsRec(grid, i, j - 1, visited);
		numIslandsRec(grid, i + 1, j, visited);
		numIslandsRec(grid, i, j + 1, visited);
	}
}
