package me.algo.leetcode;

import java.util.Stack;

public class Lc0084LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			if (i == 0 || heights[i] >= heights[i - 1]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
					int curr = stack.pop();
					int length = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
					int height = length * heights[curr];
					max = Math.max(max, height);
				}
				stack.push(i);
			}
		}

		while (!stack.isEmpty()) {
			int curr = stack.pop();
			int length = heights.length - (stack.isEmpty() ? 0 : stack.peek() + 1);
			int height = length * heights[curr];
			max = Math.max(max, height);
		}

		return max;
	}
}
