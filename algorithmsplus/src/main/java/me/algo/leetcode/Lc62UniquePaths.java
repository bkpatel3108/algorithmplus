package me.algo.leetcode;

public class Lc62UniquePaths {
	public int uniquePathsRec(int m, int n) {
		Integer[][] memo = new Integer[m][n];
		return uniquePathsRec(m - 1, n - 1, memo);
	}

	public int uniquePathsRec(int m, int n, Integer[][] memo) {
		if (memo[m][n] != null)
			return memo[m][n];
		if (m == 0 || n == 0) {
			memo[m][n] = 1;
			return 1;
		}
		memo[m][n] = uniquePathsRec(m - 1, n, memo) + uniquePathsRec(m, n - 1, memo);
		return memo[m][n];
	}

	public int uniquePaths(int m, int n) {
		Integer[][] table = new Integer[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 1;
					continue;
				}
				table[i][j] = table[i - 1][j] + table[i][j - 1];
			}
		}

		return table[m - 1][n - 1];
	}
}
