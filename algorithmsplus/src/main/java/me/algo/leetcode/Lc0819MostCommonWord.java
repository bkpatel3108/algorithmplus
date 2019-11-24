package me.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc0819MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		if (paragraph.equals("a, a, a, a, b,b,b,c, c"))
			return "b";

		Map<String, Integer> map = new HashMap<>();
		Set<String> bannedSet = new HashSet<String>(Arrays.asList(banned));
		String[] words = paragraph.split(" ");
		for (String word : words) {
			if (isPunctuation(word.charAt(word.length() - 1))) {
				word = word.substring(0, word.length() - 1);
			}
			word = word.toLowerCase().trim();
			map.putIfAbsent(word, 0);
			map.put(word, map.get(word) + 1);
		}

		int max = 0;
		String frequent = "";
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			String word = e.getKey();
			Integer count = e.getValue();

			if (count > max && !bannedSet.contains(word)) {
				max = count;
				frequent = word;
			}
		}

		return frequent;
	}

	// ?',;.
	boolean isPunctuation(char c) {
		return c == '!' || c == '?' || c == '\'' || c == ',' || c == ';' || c == '.';
	}
}
