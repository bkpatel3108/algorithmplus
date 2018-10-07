package me.algo.leetcode;

public class Lc0005LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;
		char[] arr = s.toCharArray();
		int max = 0;
		int maxStart = 0;
		int maxEnd = 0;
		for (int i = 0; i < arr.length; i++) {
			// odd palindrome
			int l = i - 1;
			int r = i + 1;
			int curr = 1 + getPalindromeLengthHelper(arr, l, r);
			if (curr > max) {
				max = curr;
				maxStart = i - curr / 2;
				maxEnd = i + curr / 2;
			}

			// even palindrome
			l = i;
			r = i + 1;
			curr = getPalindromeLengthHelper(arr, l, r);
			if (curr > max) {
				max = curr;
				maxStart = l - curr / 2 + 1;
				maxEnd = r + curr / 2 - 1;
			}
		}

		return s.substring(maxStart, maxEnd + 1);
	}

	int getPalindromeLengthHelper(char[] arr, int l, int r) {
		int len = 0;
		while (l >= 0 && r < arr.length) {
			if (arr[l] == arr[r]) {
				len += 2;
			} else {
				break;
			}
			l--;
			r++;
		}
		return len;
	}
}
