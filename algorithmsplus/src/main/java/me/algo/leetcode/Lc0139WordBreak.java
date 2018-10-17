package me.algo.leetcode;

import java.util.List;
import java.util.Set;

public class Lc0139WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				boolean flag = (wordDict.contains(s.substring(j, i)) && dp[j]) ? true : false;
				if (flag == true) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
		// return wordBreakRec(s, wordDict, s.length(), new
		// Boolean[s.length()+1]);
	}

	public boolean wordBreakRec(String s, List<String> wordDict, int i, Boolean[] memo) {
		if (memo[i] != null)
			return memo[i];
		if (i <= 0)
			return true;
		boolean flag = false;
		for (int j = i - 1; j >= 0; j--) {
			flag = (wordDict.contains(s.substring(j, i)) && wordBreakRec(s, wordDict, j, memo)) ? true : false;
			if (flag == true)
				break;
		}
		memo[i] = flag;
		return flag;
	}

	public boolean wordBreak1(String str, List<String> wordDict) {
		boolean[] table = new boolean[str.length() + 1];
		table[0] = true;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String newStr = str.substring(i, j);
				if (wordDict.contains(newStr)) {
					table[j] = table[j] || table[i];
				}
			}
		}
		return table[str.length()];
	}

	// Not tested recursive
	public boolean wordBreakRec1(String str, List<String> dic, int i, Boolean[] memo) {
		if (memo[i] != null)
			return memo[i];

		boolean flag = false;
		if (i == str.length())
			flag = true;

		for (int j = i + 1; j <= str.length(); j++) {
			String newStr = str.substring(i, j);
			if (dic.contains(newStr)) {
				flag = flag || wordBreakRec1(str, dic, j, memo);
			}
		}
		memo[i] = flag;
		return flag;
	}
}
