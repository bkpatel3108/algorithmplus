package me.algo.leetcode;

public class Lc0917ReverseOnlyLetters {
	public String reverseOnlyLetters(String S) {
		int l = 0;
		int r = S.length() - 1;
		char[] arr = S.toCharArray();
		while (l < r) {
			if (!Character.isLetter(arr[l])) {
				l++;
				continue;
			}

			if (!Character.isLetter(arr[r])) {
				r--;
				continue;
			}

			char temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++;
			r--;
		}

		return new String(arr);
	}
}
