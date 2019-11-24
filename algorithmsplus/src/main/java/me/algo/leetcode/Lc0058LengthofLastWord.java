package me.algo.leetcode;

public class Lc0058LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int lastCharIdx = -1;
		char[] sArr = s.toCharArray();
		int i = s.length() - 1;
		while (i >= 0) {
			if (sArr[i] == ' ') {
				if (lastCharIdx != -1)
					break;
			} else {
				if (lastCharIdx == -1)
					lastCharIdx = i;
			}
			i--;
		}

		if (lastCharIdx == -1)
			return 0;

		return lastCharIdx - i;
	}
}
