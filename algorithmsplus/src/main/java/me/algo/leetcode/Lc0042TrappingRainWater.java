package me.algo.leetcode;

import java.util.Stack;

public class Lc0042TrappingRainWater {
	public int trap(int[] height) {
		int totalArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && (height[i] > height[stack.peek()])) {
				int topEle = stack.pop();
				if (!stack.isEmpty()) {
					int distance = i - stack.peek() - 1;
					int boundedHeight = Math.min(height[stack.peek()], height[i]) - height[topEle];
					int area = distance * boundedHeight;
					totalArea += area;
				}
			}
			stack.push(i);
		}
		return totalArea;
	}
}
