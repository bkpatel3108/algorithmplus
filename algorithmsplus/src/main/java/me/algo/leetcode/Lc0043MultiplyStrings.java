package me.algo.leetcode;

public class Lc0043MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || num1.equals("") || num2.equals(""))
			return null;

		char[] num1Arr = num1.toCharArray();
		char[] num2Arr = num2.toCharArray();
		int[] ansArr = new int[num1Arr.length + num2Arr.length];

		for (int i = num2Arr.length - 1; i >= 0; i--) {
			for (int j = num1Arr.length - 1; j >= 0; j--) {
				ansArr[i + j + 1] += ((int) num2Arr[i] - (int) '0') * ((int) num1Arr[j] - (int) '0');
			}
		}

		int carry = 0;
		for (int i = ansArr.length - 1; i >= 0; i--) {
			int curr = ansArr[i] + carry;
			carry = 0;
			if (curr >= 10) {
				carry = curr / 10;
				curr = curr % 10;
			}
			ansArr[i] = curr;
		}

		StringBuilder sb = new StringBuilder("");
		boolean leadingZeros = true;
		for (int i : ansArr) {
			if (i == 0 && leadingZeros == true) {
				continue;
			} else {
				leadingZeros = false;
				sb.append(i);
			}
		}

		return sb.toString().equals("") ? "0" : sb.toString();
	}
}
