package me.algo.leetcode;

public class Lc0007ReverseInteger {
	public int reverse(int num) {
		if (num > 0) {
			return reversePositiveInterger(num);
		} else if (num < 0) {
			return -1 * reversePositiveInterger(-1 * num);
		} else {
			return 0;
		}
	}

	private int reversePositiveInterger(int num) {
		int reverse = 0;
		while (num > 0) {
			int div = num % 10;
			int preRevVal = reverse;
			reverse = (reverse * 10) + div;
			// check overflow
			if ((reverse - div) / 10 != preRevVal) {
				return 0;
			}
			num = num / 10;
		}
		return reverse;
	}
}
