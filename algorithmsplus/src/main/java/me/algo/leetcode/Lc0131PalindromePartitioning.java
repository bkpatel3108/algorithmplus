package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0131PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		partition(s, result, new ArrayList<String>(), 0);
		return result;
	}

	public void partition(String s, List<List<String>> result, List<String> currList, int start) {
		if (start == s.length()) {
			result.add(new ArrayList<String>(currList));
			return;
		}

		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				currList.add(s.substring(start, i + 1));
				partition(s, result, currList, i + 1);
				currList.remove(currList.size() - 1);
			}
		}
	}

	boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
