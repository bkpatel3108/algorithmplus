package me.algo.leetcode;

public class Lc14LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length < 1)
			return "";
		if (strs.length == 1)
			return strs[0];
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < strs[0].length(); i++) {
			char fstStrChar = strs[0].charAt(i);
			for (int j = 0; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != fstStrChar)
					return ans.toString();
			}
			ans.append(fstStrChar);
		}

		return ans.toString();
	}
}
