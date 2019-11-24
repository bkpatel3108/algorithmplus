package me.algo.leetcode;

import java.util.Stack;

public class Lc0901OnlineStockSpan {
	Stack<StockPair> stack;

	public Lc0901OnlineStockSpan() {
		stack = new Stack<>();
	}

	public int next(int price) {
		int currSpan = 1;
		if (stack.isEmpty()) {
			stack.push(new StockPair(price, 1));
		} else {
			while (!stack.isEmpty() && stack.peek().price <= price) {
				StockPair topPair = stack.pop();
				currSpan += topPair.span;
			}
			stack.push(new StockPair(price, currSpan));
		}
		return currSpan;
	}

	class StockPair {
		int price;
		int span;

		StockPair(int price, int span) {
			this.price = price;
			this.span = span;
		}
	}
}
