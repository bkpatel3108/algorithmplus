package me.algo.leetcode;

public class Lc0011ContainerWithMostWater {
	public int maxArea(int[] height) {
		int start = 0;
		int end = height.length - 1;
		int maxArea = 0;
		while (start < end) {
			int area = area(Math.min(height[start], height[end]), start, end);
			maxArea = Math.max(area, maxArea);
			if (height[start] <= height[end]) {
				start++;
			} else {
				end--;
			}
		}
		return maxArea;
	}

	int area(int height, int start, int end) {
		return (end - start) * height;
	}
}
