package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0022GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		generateParenthesisRec(n, result, "", 0, 0);
		return result;
	}

	public void generateParenthesisRec(int limit, List<String> result, String curr, int left, int right) {
		if (curr.length() == limit * 2) {
			result.add(curr);
		}

		if (left < limit)
			generateParenthesisRec(limit, result, curr + "(", left + 1, right);
		if (right < left)
			generateParenthesisRec(limit, result, curr + ")", left, right + 1);
	}
}
