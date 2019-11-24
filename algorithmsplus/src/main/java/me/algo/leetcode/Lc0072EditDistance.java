package me.algo.leetcode;

import java.util.Arrays;

public class Lc0072EditDistance {
	public int minDistance(String word1, String word2) {
		int[][] memo = new int[word1.length()][word2.length()];
		for (int[] row : memo)
			Arrays.fill(row, -1);
		return minDistanceRec(word1.toCharArray(), word2.toCharArray(), 0, 0, memo);
	}

	public int minDistanceRec(char[] word1, char[] word2, int i, int j, int[][] memo) {
		if (i == word1.length && j == word2.length)
			return 0;
		if (i == word1.length)
			return word2.length - j;
		if (j == word2.length)
			return word1.length - i;
		
		if(memo[i][j] != -1){
			return memo[i][j];
		}

		int minDistance = 0;

		int charReplaceDistance = minDistanceRec(word1, word2, i + 1, j + 1, memo);
		if (word1[i] != word2[j])
			charReplaceDistance++;

		minDistance = Math.min(charReplaceDistance,
				1 + Math.min(minDistanceRec(word1, word2, i, j + 1, memo), minDistanceRec(word1, word2, i + 1, j, memo)));
		
		memo[i][j] = minDistance;
		return minDistance;
	}
}
