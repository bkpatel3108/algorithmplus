package me.algo.leetcode;

public class Lc3LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		boolean[] charFlag = new boolean[256];
		char[] inputChars = s.toCharArray();
		int start = 0;
		for (int i = 0; i < inputChars.length; i++) {
			if (charFlag[inputChars[i]]) {
				int curr = i - start;
				max = Math.max(max, curr);
				charFlag = new boolean[256];
				start = i;
			}
			charFlag[inputChars[i]] = true;
		}
		max = Math.max(max, inputChars.length - start);
		return max;
	}
}
