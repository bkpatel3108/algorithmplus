package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0816AmbiguousCoordinates {
	public List<String> ambiguousCoordinates(String S) {

		List<String> result = new ArrayList<>();
		S = S.substring(1, S.length() - 1);
		for (int i = 0; i < S.length() - 1; i++) {
			String x = S.substring(0, i + 1);
			String y = S.substring(i + 1, S.length());

			if (!leadingZeros(x) && !leadingZeros(y)) {
				result.add("(" + x + "," + " " + y + ")");
			}

			List<String> xDecimals = generateDecimals(x);
			List<String> yDecimals = generateDecimals(y);

			for (String xd : xDecimals) {
				for (String yd : yDecimals) {
					result.add("(" + xd + "," + " " + yd + ")");
				}
			}

			if (!leadingZeros(x)) {
				for (String yd : yDecimals) {
					result.add("(" + x + "," + " " + yd + ")");
				}
			}

			if (!leadingZeros(y)) {
				for (String xd : generateDecimals(x)) {
					result.add("(" + xd + "," + " " + y + ")");
				}
			}
		}

		return result;
	}

	boolean leadingZeros(String s) {
		return s.length() > 1 && s.charAt(0) == '0';
	}

	boolean trailingZeros(String s) {
		return s.length() > 0 && s.charAt(s.length() - 1) == '0';
	}

	List<String> generateDecimals(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() < 2)
			return result;

		for (int i = 0; i < s.length() - 1; i++) {
			String first = s.substring(0, i + 1);
			String second = s.substring(i + 1, s.length());

			if (!leadingZeros(first) && !trailingZeros(second))
				result.add(first + "." + second);
		}

		return result;
	}
}
