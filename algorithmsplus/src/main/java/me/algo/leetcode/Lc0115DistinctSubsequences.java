package me.algo.leetcode;

import java.util.stream.IntStream;

public class Lc0115DistinctSubsequences {
	public int numDistinct(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0)
			return 0;
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		// Integer memo[][] = new Integer[s.length()+1][t.length()+1];
		// int ways = numDistinct1(sArr, tArr, 0, 0, memo);
		// for(int i=0; i<memo.length; i++){
		// for(int j=0; j<memo[0].length; j++){
		// System.out.print(memo[i][j] + "\t");
		// }
		// System.out.println();
		// }
		// return ways;
		return numDistinct1(sArr, tArr);
	}

	// Using suffix method
	// O(n^3) algo
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

	// Using Bottom up method
	// O(n^3) algo
	public int numDistinct(char[] s, char[] t) {
		int[][] table = new int[s.length][t.length];
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < t.length; j++) {
				if (s[i] == t[j]) {
					if (j == 0) {
						table[i][j] = 1;
					} else {
						for (int k = i; k >= 1; k--) {
							table[i][j] += table[k - 1][j - 1];
						}
					}
				}
			}
		}
		// for(int i=0; i<table.length; i++){
		// for(int j=0; j<table[0].length; j++){
		// System.out.print(table[i][j] + "\t");
		// }
		// System.out.println();
		// }
		int ways = 0;
		for (int i = 0; i < table.length; i++) {
			ways += table[i][table[0].length - 1];
		}
		return ways;
	}

	// Using suffix method
	// O(n^2) algo
	public int numDistinct1(char[] s, char[] t, int i, int j, Integer[][] memo) {
		if (memo[i][j] != null)
			return memo[i][j];
		if (j == t.length) {
			memo[i][j] = 1;
			return 1;
		}
		if (i == s.length) {
			memo[i][j] = 0;
			return 0;
		}
		int ways = 0;
		if (s[i] == t[j])
			ways += numDistinct1(s, t, i + 1, j + 1, memo);

		ways += numDistinct1(s, t, i + 1, j, memo);
		memo[i][j] = ways;
		return ways;
	}

	// Using Bottom up method
	// O(n^2) algo
	public int numDistinct1(char[] s, char[] t) {
		int[][] table = new int[s.length + 1][t.length + 1];

		// fill first row with 0
		IntStream.range(0, table[0].length).forEach(j -> table[0][j] = 0);

		// fill first column with 1
		IntStream.range(0, table.length).forEach(i -> table[i][0] = 1);

		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[0].length; j++) {
				// 1 behind in index of strings as we need intial values in
				// table.
				// table[1][1] referes to s[0] t[0]
				table[i][j] = table[i - 1][j];
				if (s[i - 1] == t[j - 1]) {
					table[i][j] += table[i - 1][j - 1];
				}
			}
		}
		// for(int i=0; i<table.length; i++){
		// for(int j=0; j<table[0].length; j++){
		// System.out.print(table[i][j] + "\t");
		// }
		// System.out.println();
		// }
		return table[table.length - 1][table[0].length - 1];
	}
}
