package me.algo.leetcode;

import java.util.Stack;

public class Lc0085MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] height = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0) {
						height[i][j] = 1;
					} else {
						height[i][j] = height[i - 1][j] + 1;
					}
				} else {
					height[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < height.length; i++) {
			max = Math.max(max, findBiggestRactangleInHistogram(height[i]));
		}

		return max;

	}

	private int findBiggestRactangleInHistogram(int[] h) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i < h.length; i++) {
			if (i == 0 || h[i] >= h[i - 1]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
					int curr = stack.pop();
					int length = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
					int area = length * h[curr];
					max = Math.max(max, area);
				}
				stack.push(i);
			}
		}

		while (!stack.isEmpty()) {
			int curr = stack.pop();
			int length = h.length - (stack.isEmpty() ? 0 : stack.peek() + 1);
			int area = length * h[curr];
			max = Math.max(max, area);
		}

		return max;
	}
}
