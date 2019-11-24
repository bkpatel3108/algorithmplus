package me.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc0140WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<Integer, List<String>> memo = new HashMap<>();
		return wordBreakRec(s, wordDict, s.length(), memo);
	}

	public List<String> wordBreakRec(String s, List<String> wordDict, int i, Map<Integer, List<String>> memo) {
		if (memo.containsKey(i))
			return memo.get(i);
		List<String> result = new ArrayList<>();
		if (i == 0) {
			result.add("");
		}
		for (int j = i - 1; j >= 0; j--) {
			String currWord = s.substring(j, i);
			if (wordDict.contains(currWord)) {
				List<String> words = wordBreakRec(s, wordDict, j, memo);
				for (String word : words) {
					result.add((word + " " + currWord).trim());
				}
			}
		}
		memo.put(i, result);
		return result;
	}
}
