package me.algo.leetcode;

import java.util.Stack;

public class Lc0155MinStack {
	private Stack<Integer> numStack;
	private Stack<Integer> minStack;

	/** initialize your data structure here. */
	public Lc0155MinStack() {
		numStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		numStack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek())
			minStack.push(x);
	}

	public void pop() {
		Integer val = null;
		if (!numStack.isEmpty()) {
			val = numStack.pop();
		}
		if (val != null && minStack.peek().equals(val)) {
			minStack.pop();
		}
	}

	public int top() {
		return numStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
