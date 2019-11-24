package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0054SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;
		int r = matrix.length;
		int c = matrix[0].length;
		int min = Math.min(r, c);
		int len = min % 2 == 0 ? min / 2 : min / 2 + 1;
		int curr = 0;
		while (curr < len) {
			// left direction
			for (int i = curr, j = curr; j < c - curr; j++)
				result.add(matrix[i][j]);
			// down direction
			for (int i = curr + 1, j = c - curr - 1; i < r - curr; i++)
				result.add(matrix[i][j]);
			// right direction
			for (int i = r - curr - 1, j = c - curr - 2; j >= curr && i > curr; j--)
				result.add(matrix[i][j]);
			// up direction
			for (int i = r - curr - 2, j = curr; i > curr && j < c - curr - 1; i--)
				result.add(matrix[i][j]);
			curr++;
		}

		return result;
	}
}
