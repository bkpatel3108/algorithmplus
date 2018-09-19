package me.algo.leetcode;

public class Lc125ValidPalindrome {
	public boolean isPalindrome(String s) {
		char[] arr = s.toCharArray();
		int l = 0;
		int r = arr.length - 1;

		while (l < r) {
			if (Character.isLetterOrDigit(arr[l]) && Character.isLetterOrDigit(arr[r])) {
				if (Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[r]))
					return false;
				l++;
				r--;
			} else {
				if (!Character.isLetterOrDigit(arr[l])) {
					l++;
				} else {
					r--;
				}
			}
		}

		return true;
	}
}
