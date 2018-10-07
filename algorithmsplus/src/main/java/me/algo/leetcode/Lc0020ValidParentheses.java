package me.algo.leetcode;

import java.util.Stack;

public class Lc0020ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] charArr = s.toCharArray();
		for (char c : charArr) {
			if (c == '(' || c == '{' || c == '[')
				stack.push(c);
			else {
				if (stack.isEmpty())
					return false;
				else {
					char topChar = stack.pop();
					if (c == ')' && topChar != '(' || c == '}' && topChar != '{' || c == ']' && topChar != '[')
						return false;
				}
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
}
