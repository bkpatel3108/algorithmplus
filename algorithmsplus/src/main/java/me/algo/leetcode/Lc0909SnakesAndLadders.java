package me.algo.leetcode;

import java.util.LinkedList;

public class Lc0909SnakesAndLadders {
	public int snakesAndLadders(int[][] board) {
		int n = board.length;
		int start = 1;
		int end = n * n;
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n * n + 1];
		queue.add(start);
		visited[start] = true;
		int step = 0;
		while (queue.size() > 0) {
			int counter = queue.size();
			while (counter-- > 0) {
				int currBlock = queue.removeFirst();
				if (currBlock == end) {
					return step;
				}
				for (int i = 1; i <= 6; i++) {
					int nextMove = currBlock + i;
					int moveIndex = getMoveIndex(board, nextMove);
					if (moveIndex != -1) {
						nextMove = moveIndex;
					}
					if (nextMove <= n * n && !visited[nextMove]) {
						queue.addLast(nextMove);
						visited[nextMove] = true;
					}
				}
			}
			step++;
		}

		return -1;
	}

	int getMoveIndex(int[][] board, int block) {
		int n = board.length;
		if (block > n * n)
			return -1;

		int r = (n - 1) - ((block - 1) / n);
		int c;
		if ((n - 1 - r) % 2 == 0) {
			c = (block - 1) % n;
		} else {
			c = (n - 1) - ((block - 1) % n);
		}
		return board[r][c];
	}
}
