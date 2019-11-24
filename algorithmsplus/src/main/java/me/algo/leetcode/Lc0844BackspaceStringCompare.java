package me.algo.leetcode;

import java.util.Stack;

public class Lc0844BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		if (S == null && T == null)
			return true;

		if (S == null || T == null)
			return false;

		return generateBackspaceCompareString(S).equals(generateBackspaceCompareString(T));
	}

	String generateBackspaceCompareString(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '#') {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(c);
			}
		}

		StringBuffer ssb = new StringBuffer("");
		while (!stack.isEmpty()) {
			ssb.append(String.valueOf(stack.pop()));
		}

		return ssb.toString();
	}
}
