package me.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc0076MinimumWindowSubstring {
	public String minWindow(String s, String t) {

		int st = 0, e = 0;
		int min = Integer.MAX_VALUE;
		char[] sArr = s.toCharArray();
		Map<Character, Integer> map = generateFrqMap(t);
		int cnt = t.length();
		String minStr = "";

		while (e < sArr.length) {
			char c = sArr[e];
			if (map.containsKey(c)) {
				if (map.get(c) > 0) {
					cnt--;
				}
				map.put(c, map.get(c) - 1);
			}

			while (cnt == 0) {
				if (e - st < min) {
					min = e - st;
					minStr = s.substring(st, e + 1);
				}
				char stChar = sArr[st];
				if (map.containsKey(stChar)) {
					if (map.get(stChar) == 0) {
						cnt++;
					}
					map.put(stChar, map.get(stChar) + 1);
				}
				st++;
			}
			e++;
		}

		return minStr;
	}

	Map<Character, Integer> generateFrqMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}
		return map;
	}
}
