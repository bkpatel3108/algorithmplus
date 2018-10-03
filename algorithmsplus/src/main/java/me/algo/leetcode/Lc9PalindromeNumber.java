package me.algo.leetcode;

public class Lc9PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int rev = 0;

		int curr = x;
		while (curr > 0) {
			rev = rev * 10 + curr % 10;
			curr = curr / 10;
		}

		return x == rev;
	}
}
