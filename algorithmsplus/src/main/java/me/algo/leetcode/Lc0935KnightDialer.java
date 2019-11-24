package me.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc0935KnightDialer {
	public int knightDialer(int N) {
		if (N < 1)
			return 0;
		if (N == 1)
			return 10;
		if (N == 2)
			return 20;

		Map<Integer, int[]> hm = getKnightMovingHM();
		int[] curr = countKnightMovingHM(hm);
		int[] next = new int[10];
		int modulo = 1000000007;
		int cnt = 3;
		while (cnt <= N) {
			for (int i = 0; i < 10; i++) {
				int[] list = hm.get(i);
				for (int no : list) {
					next[i] += curr[no];
					next[i] %= modulo;
				}
			}
			cnt++;
			curr = next;
			next = new int[10];
		}
		return Arrays.stream(curr).reduce(0, (sum, i) -> (sum + i) % modulo);
	}

	Map<Integer, int[]> getKnightMovingHM() {
		Map<Integer, int[]> hm = new HashMap<>();
		hm.put(0, new int[] { 4, 6 });
		hm.put(1, new int[] { 6, 8 });
		hm.put(2, new int[] { 7, 9 });
		hm.put(3, new int[] { 4, 8 });
		hm.put(4, new int[] { 0, 3, 9 });
		hm.put(5, new int[] {});
		hm.put(6, new int[] { 0, 1, 7 });
		hm.put(7, new int[] { 2, 6 });
		hm.put(8, new int[] { 1, 3 });
		hm.put(9, new int[] { 2, 4 });
		return hm;
	}

	int[] countKnightMovingHM(Map<Integer, int[]> hm) {
		int arr[] = new int[10];
		hm.entrySet().forEach(e -> arr[e.getKey()] = e.getValue().length);
		return arr;
	}
}
