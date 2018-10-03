package me.algo.leetcode;

import java.util.Arrays;

public class Lc10RegularExpressionMatching {
	public boolean isMatch(final String A, final String B) {
		if (A == null || B == null)
			return false;
		int[][] memo = new int[A.length() + 1][B.length() + 1];
		for (int[] arr : memo) {
			Arrays.fill(arr, -1);
		}
		// convert my interview bit submission to leetcode
		// return isMatchRec(A.toCharArray(), B.toCharArray(), 0, 0, memo);
		return isMatchRec(A.toCharArray(), B.toCharArray(), 0, 0, memo) == 0 ? false : true;
	}

	public int isMatchRec(char[] a, char[] b, int i, int j, int[][] memo) {
		if (memo[i][j] != -1)
			return memo[i][j];
		if (i == a.length && j == b.length) {
			memo[i][j] = 1;
			return 1;
		} else if (j == b.length) {
			memo[i][j] = 0;
			return 0;
		} else if (i == a.length) {
			memo[i][j] = j < b.length - 1 && b[j + 1] == '*' ? isMatchRec(a, b, i, j + 2, memo) : 0;
			return memo[i][j];
		}

		if (j < b.length - 1 && b[j + 1] == '*') {
			if (a[i] == b[j] || b[j] == '.') {
				memo[i][j] = isMatchRec(a, b, i + 1, j, memo) | isMatchRec(a, b, i, j + 2, memo);
			} else {
				memo[i][j] = isMatchRec(a, b, i, j + 2, memo);
			}
		} else {
			if (a[i] == b[j] || b[j] == '.') {
				memo[i][j] = isMatchRec(a, b, i + 1, j + 1, memo);
			} else {
				return 0;
			}
		}
		return memo[i][j];
	}

	public int isMatchDp(final String A, final String B) {
		if (A == null || B == null)
			return 0;
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] table = new int[A.length() + 1][B.length() + 1];
		table[0][0] = 1;
		for (int j = 0; j < b.length; j++)
			if (b[j] == '*')
				table[0][j + 1] = 1;
			else
				break;
		for (int i = 1; i <= a.length; i++) {
			for (int j = 1; j <= b.length; j++) {
				if (a[i - 1] == b[j - 1] || b[j - 1] == '.') {
					table[i][j] = table[i - 1][j - 1];
				} else if (b[j - 1] == '*') {
					table[i][j] = table[i][j - 1] | table[i - 1][j - 1] | table[i - 1][j];
				}
			}
		}

		return table[A.length()][B.length()];
	}

	public int isMatchDpSpaceOptimization(final String A, final String B) {
		if (A == null || B == null)
			return 0;
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[] preRow = new int[B.length() + 1];
		int[] currRow = new int[B.length() + 1];
		preRow[0] = 1;
		for (int j = 0; j < b.length; j++)
			if (b[j] == '*')
				preRow[j + 1] = 1;
			else
				break;
		for (int i = 1; i <= a.length; i++) {
			for (int j = 1; j <= b.length; j++) {
				if (a[i - 1] == b[j - 1] || b[j - 1] == '.') {
					currRow[j] = preRow[j - 1];
				} else if (b[j - 1] == '*') {
					currRow[j] = currRow[j - 1] | preRow[j - 1] | preRow[j];
				}
			}
			preRow = currRow;
			currRow = new int[B.length() + 1];
		}

		return preRow[B.length()];
	}
}
