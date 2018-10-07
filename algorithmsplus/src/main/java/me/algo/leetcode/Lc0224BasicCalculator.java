package me.algo.leetcode;

import java.util.Stack;

public class Lc0224BasicCalculator {
	public int calculate(String s) {
		char[] exp = s.toCharArray();
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == ' ') {
				continue;
			} else if (exp[i] == ')') {
				stack.push(calculate(stack));
			} else {
				if (exp[i] == '(' || exp[i] == '+' || exp[i] == '-') {
					stack.push(String.valueOf(exp[i]));
				} else {
					String val = String.valueOf(exp[i]);
					while (i < exp.length - 1 && Character.isDigit(exp[i + 1])) {
						val += exp[i + 1];
						i++;
					}
					stack.push(val);
				}
			}
		}

		return Integer.parseInt(calculate(stack));
	}

	String apply(String op1, String op2, String opr) {
		int a = Integer.parseInt(op1);
		int b = Integer.parseInt(op2);
		if (opr.equals("+"))
			return String.valueOf(a + b);
		else
			return String.valueOf(a - b);
	}

	String calculate(Stack<String> stack) {
		Stack<String> tempStack = new Stack<>();
		while (!stack.isEmpty() && !stack.peek().equals("(")) {
			tempStack.push(stack.pop());
		}

		if (!stack.isEmpty() && stack.peek().equals("("))
			stack.pop();

		while (tempStack.size() >= 3) {
			String op1 = tempStack.pop();
			String opr = tempStack.pop();
			String op2 = tempStack.pop();
			tempStack.push(apply(op1, op2, opr));
		}
		return tempStack.pop();
	}
}
