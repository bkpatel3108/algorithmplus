package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc17LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> currList = new ArrayList<String>();

		if (digits == null || digits.length() == 0) {
			return currList;
		}

		Map<Character, List<String>> digitLetterMap = getDigitLetterMap();

		currList.add("");
		for (char c : digits.toCharArray()) {
			List<String> newList = new ArrayList<String>();
			List<String> currChars = digitLetterMap.get(c);
			for (String s1 : currChars) {
				for (String s2 : currList) {
					newList.add(s2 + s1);
				}
			}
			currList = newList;
		}
		return currList;
	}

	private Map<Character, List<String>> getDigitLetterMap() {
		Map<Character, List<String>> digitLetterMap = new HashMap<>();
		digitLetterMap.put('2', Arrays.asList("a", "b", "c"));
		digitLetterMap.put('3', Arrays.asList("d", "e", "f"));
		digitLetterMap.put('4', Arrays.asList("g", "h", "i"));
		digitLetterMap.put('5', Arrays.asList("j", "k", "l"));
		digitLetterMap.put('6', Arrays.asList("m", "n", "o"));
		digitLetterMap.put('7', Arrays.asList("p", "q", "r", "s"));
		digitLetterMap.put('8', Arrays.asList("t", "u", "v"));
		digitLetterMap.put('9', Arrays.asList("w", "x", "y", "z"));
		return digitLetterMap;
	}
}
