package me.algo.leetcode;

import java.util.Arrays;

public class Lc0052NQueensII {
	public int totalNQueens(int n) {
		int[] columns = new int[n];
		Arrays.fill(columns, -1);
		Counter cnt = new Counter();
		solveNQueensBackTrack(n, columns, 0, cnt);
		return cnt.get();
	}

	public void solveNQueensBackTrack(int n, int[] columns, int row, Counter cnt) {
		if (row == n) {
			cnt.increment();
		} else {
			for (int i = 0; i < n; i++) {
				boolean canPlace = true;
				for (int j = 0; j < row; j++) {
					if (i == columns[j] || row - i == j - columns[j] || row + i == j + columns[j]) {
						canPlace = false;
						break;
					}
				}
				if (canPlace == true) {
					columns[row] = i;
					solveNQueensBackTrack(n, columns, row + 1, cnt);
					columns[row] = -1;
				}
			}
		}
	}

	class Counter {
		int cnt = 0;

		void increment() {
			cnt++;
		}

		int get() {
			return cnt;
		}
	}
}
