package me.algo.leetcode;

public class Lc0048RotateImage {
	public void rotate(int[][] matrix) {
		int layer = matrix.length / 2;

		for (int i = 0; i < layer; i++) {
			for (int j = i; j < matrix.length - 1 - i; j++) {
				int len = matrix.length - 1;
				int temp = matrix[i][j];
				matrix[i][j] = matrix[len - j][i];
				matrix[len - j][i] = matrix[len - i][len - j];
				matrix[len - i][len - j] = matrix[j][len - i];
				matrix[j][len - i] = temp;
			}
		}

	}
}
