package me.algo.leetcode;

public class Lc0008StringtoIntegerAtoi {
	public int myAtoi(String str) {
		char[] strArr = str.toCharArray();
		int value = 0;

		// find first char as sign or number else return 0
		int i = 0;
		for (; i < strArr.length; i++) {
			if (strArr[i] == ' ')
				continue;
			else if (Character.isDigit(strArr[i]) || strArr[i] == '-' || strArr[i] == '+')
				break;
			else
				return 0;
		}

		if (i == strArr.length)
			return 0;

		boolean minus = false;
		if (strArr[i] == '-') {
			minus = true;
			i++;
		} else if (strArr[i] == '+') {
			i++;
		}

		// find end index of integer
		int j = i;
		while (j < strArr.length) {
			if (!Character.isDigit(strArr[j]))
				break;
			j++;
		}

		String noStr = str.substring(i, j);
		char[] noStrArr = noStr.toCharArray();

		for (int k = 0; k < noStrArr.length; k++) {
			if (minus) {
				if (value > Integer.MAX_VALUE / 10 || (value == Integer.MAX_VALUE / 10 && noStrArr[k] - '0' > 8))
					return Integer.MIN_VALUE;
			} else {
				if (value > Integer.MAX_VALUE / 10 || (value == Integer.MAX_VALUE / 10 && noStrArr[k] - '0' > 7))
					return Integer.MAX_VALUE;
			}

			value = value * 10 + (noStrArr[k] - '0');
		}

		if (minus) {
			value = value * (-1);
		}

		return value;
	}
}
