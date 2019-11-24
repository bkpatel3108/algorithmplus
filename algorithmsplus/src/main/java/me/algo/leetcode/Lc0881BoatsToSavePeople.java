package me.algo.leetcode;

import java.util.Arrays;

public class Lc0881BoatsToSavePeople {
	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int l = 0;
		int r = people.length - 1;
		int boats = 0;
		while (l <= r) {
			if (l == r) {
				boats++;
				l++;
			} else if (people[l] + people[r] <= limit) {
				boats++;
				l++;
				r--;
			} else {
				boats++;
				r--;
			}
		}

		return boats;
	}
}
