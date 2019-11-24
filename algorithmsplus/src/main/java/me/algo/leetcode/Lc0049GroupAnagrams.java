package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc0049GroupAnagrams {
	Map<String, List<String>> map = new HashMap<>();

	public List<List<String>> groupAnagrams(String[] strs) {
		for (String str : strs) {
			String sortStr = sortString(str);
			map.computeIfAbsent(sortStr, key -> new ArrayList<String>()).add(str);
		}
		return new ArrayList<List<String>>(map.values());
	}

	private String sortString(String str) {
		char[] strArr = str.toCharArray();
		Arrays.sort(strArr);
		return new String(strArr);
	}
}
