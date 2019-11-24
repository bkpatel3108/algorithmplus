package me.algo.leetcode;

import java.util.Arrays;

public class Lc0911OnlineElection {
	int[] times;
	int[] winners;

	public Lc0911OnlineElection(int[] persons, int[] times) {
		this.times = times;
		int winner = persons[0];
		int[] votes = new int[persons.length];
		winners = new int[times.length];
		for (int i = 0; i < persons.length; i++) {
			votes[persons[i]]++;
			if (votes[persons[i]] >= votes[winner]) {
				winner = persons[i];
			}
			winners[i] = winner;
		}
	}

	public int q(int t) {
		int search = Arrays.binarySearch(times, t);
		if (search < 0) {
			search = (search + 2) * (-1);
		}
		return winners[search];
	}
}
