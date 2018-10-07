package me.algo.leetcode;

public class Lc0028ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0)
			return 0;
		if (haystack == null || haystack.length() == 0 || needle.length() > haystack.length())
			return -1;
		for (int i = 0; i < haystack.length(); i++) {
			for (int j = 0; j < needle.length() && i + j < haystack.length(); j++) {
				if (haystack.charAt(i + j) == needle.charAt(j)) {
					if (j == needle.length() - 1)
						return i;
				} else {
					break;
				}
			}
		}
		return -1;
	}
}
