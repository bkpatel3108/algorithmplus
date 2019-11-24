package me.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Lc0079WordSearch {
	public boolean exist(char[][] board, String word) {
		char[] wordArr = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (existRec(board, wordArr, i, j, 0, new HashSet<String>()) == true)
					return true;
			}
		}
		return false;
	}

	public boolean existRec(char[][] board, char[] word, int i, int j, int wi, Set<String> set) {
		if (wi == word.length)
			return true;

		if (i < 0 || i == board.length || j < 0 || j == board[0].length || set.contains(i + "-" + j))
			return false;

		if (board[i][j] == word[wi]) {
			set.add(i + "-" + j);
			boolean flag = existRec(board, word, i - 1, j, wi + 1, set) || existRec(board, word, i + 1, j, wi + 1, set)
					|| existRec(board, word, i, j - 1, wi + 1, set) || existRec(board, word, i, j + 1, wi + 1, set);
			set.remove(i + "-" + j);
			return flag;
		} else
			return false;

	}
}
