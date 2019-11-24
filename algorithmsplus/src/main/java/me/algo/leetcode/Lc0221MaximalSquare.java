package me.algo.leetcode;

public class Lc0221MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int[][] table = new int[matrix.length][matrix[0].length];
		int result = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = matrix[i][j] - '0';
				} else {
					if (matrix[i][j] == '0')
						table[i][j] = 0;
					else {
						int min = Math.min(table[i - 1][j - 1], Math.min(table[i - 1][j], table[i][j - 1]));
						table[i][j] = min + 1;
					}
				}
				result = Math.max(result, table[i][j]);
			}
		}
		return result * result;
	}
}
