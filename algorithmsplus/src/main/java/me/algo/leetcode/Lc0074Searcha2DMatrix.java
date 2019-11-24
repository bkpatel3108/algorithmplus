package me.algo.leetcode;

public class Lc0074Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int searchRow = binarySearch(getColumn(matrix, 0), target, 0, matrix.length - 1);
		System.out.println(searchRow);
		int targetSearch = binarySearch(matrix[searchRow], target, 0, matrix[searchRow].length - 1);
		System.out.println(targetSearch);

		if (matrix[searchRow][targetSearch] == target)
			return true;
		else
			return false;
	}

	private int[] getColumn(int[][] matrix, int columnNo) {
		int[] column = new int[matrix.length];
		for (int r = 0; r < matrix.length; r++) {
			column[r] = matrix[r][columnNo];
		}

		return column;
	}

	public int binarySearch(int[] arr, int target, int left, int right) {
		int ans = left;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] > target) {
				right = mid - 1;
			} else {
				ans = mid;
				left = mid + 1;
			}
		}
		return ans;
	}
}
