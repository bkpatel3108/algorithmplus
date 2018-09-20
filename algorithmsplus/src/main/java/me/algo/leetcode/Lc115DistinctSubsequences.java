package me.algo.leetcode;

public class Lc115DistinctSubsequences {
	public int numDistinct(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0)
			return 0;
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		Integer memo[][] = new Integer[s.length() + 1][t.length() + 1];
		return numDistinct(sArr, tArr, 0, 0, memo);
	}

	// Using suffix method
	public int numDistinct(char[] s, char[] t, int i, int j, Integer[][] memo) {
		if (memo[i][j] != null)
			return memo[i][j];

		if (j == t.length) {
			memo[i][j] = 1;
			return 1;
		}

		int ways = 0;
		for (int k = i; k < s.length; k++) {
			if (s[k] == t[j])
				ways += numDistinct(s, t, k + 1, j + 1, memo);
		}

		memo[i][j] = ways;
		return ways;
	}
}
