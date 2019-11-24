package me.algo.leetcode;

public class Lc0905SortArrayByParity {
	public int[] sortArrayByParity(int[] A) {
		int l = 0;
		int r = A.length - 1;

		while (l < r) {
			if (A[l] % 2 != 0 && A[r] % 2 == 0) {
				int temp = A[l];
				A[l] = A[r];
				A[r] = temp;
				l++;
				r--;
			}

			if (A[l] % 2 == 0) {
				l++;
			}

			if (A[r] % 2 != 0) {
				r--;
			}
		}

		return A;
	}
}
