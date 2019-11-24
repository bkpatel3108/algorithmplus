package me.algo.leetcode;

public class Lc0036ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean result = true;
		// validate each row
		for (int i = 0; i < board.length; i++) {
			result = result && isValidSudokuArray(board, i, 0, i, board[0].length - 1);
		}

		// validate each column
		for (int i = 0; i < board[0].length; i++) {
			result = result && isValidSudokuArray(board, 0, i, board.length - 1, i);
		}

		// validate each 3X3
		for (int i = 0; i < board.length; i += 3) {
			for (int j = 0; j < board[0].length; j += 3) {
				result = result && isValidSudokuArray(board, i, j, i + 2, j + 2);
			}
		}

		return result;
	}

	public boolean isValidSudokuArray(char[][] board, int is, int js, int ie, int je) {
		int[] digits = new int[9];
		for (int i = is; i <= ie; i++) {
			for (int j = js; j <= je; j++) {
				if (board[i][j] != '.') {
					if (digits[board[i][j] - '1'] == 1)
						return false;
					else
						digits[board[i][j] - '1'] = 1;
				}
			}
		}
		return true;
	}
}
