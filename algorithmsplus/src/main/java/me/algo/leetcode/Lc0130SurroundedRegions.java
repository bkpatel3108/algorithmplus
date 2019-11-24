package me.algo.leetcode;

public class Lc0130SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length <= 1 || board[0].length <= 1) {
			return;
		}

		// first row and last row
		for (int i = 0; i < board[0].length; i++) {
			dfsCoverBoundryORegions(board, 0, i);
			dfsCoverBoundryORegions(board, board.length - 1, i);
		}

		// first column and last column
		for (int i = 0; i < board.length; i++) {
			dfsCoverBoundryORegions(board, i, 0);
			dfsCoverBoundryORegions(board, i, board[0].length - 1);
		}

		// convert # to 0 and remaining 0 to X
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '#') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	public void dfsCoverBoundryORegions(char[][] board, int r, int c) {
		if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'O') {
			board[r][c] = '#';
			dfsCoverBoundryORegions(board, r - 1, c);
			dfsCoverBoundryORegions(board, r + 1, c);
			dfsCoverBoundryORegions(board, r, c + 1);
			dfsCoverBoundryORegions(board, r, c - 1);
		}
	}
}
