package me.algo.leetcode;

public class Lc0087ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if ((s1 == null && s2 == null) || (s1.length() == 0 && s2.length() == 0))
			return true;
		else if (s1.length() != s2.length()) {
			return false;
		} else if (s1.length() == 1) {
			return s1.equals(s2);
		} else {
			// assuming ascii chracters
			int[] cntArr = new int[128];
			for (char c : s1.toCharArray())
				cntArr[c]++;
			for (char c : s2.toCharArray())
				cntArr[c]--;
			for (int cnt : cntArr)
				if (cnt != 0)
					return false;

			boolean result = false;
			int len = s1.length();
			for (int i = 1; i < len; i++) {
				result = result || ((isScramble(s1.substring(0, i), s2.substring(0, i))
						&& isScramble(s1.substring(i), s2.substring(i)))
						|| (isScramble(s1.substring(0, i), s2.substring(len - i))
								&& isScramble(s1.substring(i), s2.substring(0, len - i))));
			}
			return result;
		}
	}
}
