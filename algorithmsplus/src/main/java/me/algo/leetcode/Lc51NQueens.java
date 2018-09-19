package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc51NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<int[]> columnslist = new ArrayList<int[]>();
		int[] columns = new int[n];
		Arrays.fill(columns, -1);
		solveNQueensBackTrack(n, columns, 0, columnslist);
		return generateOutputMatrix(columnslist, n);
	}

	public void solveNQueensBackTrack(int n, int[] columns, int row, List<int[]> columnslist) {
		if (row == n) {
			columnslist.add(Arrays.copyOf(columns, columns.length));
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
					solveNQueensBackTrack(n, columns, row + 1, columnslist);
					columns[row] = -1;
				}
			}
		}
	}

	public List<List<String>> generateOutputMatrix(List<int[]> columnslist, int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		for (int[] arr : columnslist) {
			List<String> list = new ArrayList<String>();
			for (int col : arr) {
				String row = "";
				for (int i = 0; i < n; i++) {
					if (i == col) {
						row = row + "Q";
					} else {
						row = row + ".";
					}
				}
				list.add(row);
			}
			result.add(list);
		}
		return result;
	}
}
