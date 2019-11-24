package me.algo.leetcode;

public class Lc0044WildcardMatching {
	public boolean isMatch(String s, String p) {
		return isMatchMemo(s.toCharArray(), p.toCharArray(), 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
	}

	// rec
	// public boolean isMatch(char[] s, char[] p, int i, int j) {

	// if(i == s.length){
	// if(j == p.length || allStar(p, j))
	// return true;
	// else
	// return false;
	// }

	// if(j == p.length){
	// return false;
	// }

	// if(s[i] == p[j] || p[j] == '?'){
	// return isMatch(s, p, i+1, j+1);
	// }else if(p[j] == '*'){
	// return isMatch(s, p, i+1, j) || isMatch(s, p, i, j+1);
	// }

	// return false;
	// }

	// memoization
	public boolean isMatchMemo(char[] s, char[] p, int i, int j, Boolean[][] memo) {

		if (memo[i][j] != null)
			return memo[i][j];

		if (i == s.length) {
			if (j == p.length || allStar(p, j))
				memo[i][j] = true;
			else
				memo[i][j] = false;
			return memo[i][j];
		}

		if (j == p.length) {
			memo[i][j] = false;
			return false;
		}

		boolean isMatch = false;
		if (s[i] == p[j] || p[j] == '?') {
			isMatch = isMatchMemo(s, p, i + 1, j + 1, memo);
		} else if (p[j] == '*') {
			isMatch = isMatchMemo(s, p, i + 1, j, memo) || isMatchMemo(s, p, i, j + 1, memo);
		}

		memo[i][j] = isMatch;
		return isMatch;
	}

	private boolean allStar(char[] arr, int i) {
		while (i < arr.length) {
			if (arr[i] != '*')
				return false;
			i++;
		}
		return true;
	}
}
