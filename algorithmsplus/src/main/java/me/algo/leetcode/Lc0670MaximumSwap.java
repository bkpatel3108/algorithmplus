package me.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc0670MaximumSwap {
	public int maximumSwap(int num) {
		String numStr = String.valueOf(num);
		char[] numArr = numStr.toCharArray();
		if (numArr.length > 1) {
			Map<Integer, MaxValIndexPair> map = new HashMap<Integer, MaxValIndexPair>();
			int max = numArr[numArr.length - 1];
			MaxValIndexPair maxIndexPair = new MaxValIndexPair(max, numArr.length - 1);
			map.put(numArr.length - 1, maxIndexPair);
			for (int i = numArr.length - 2; i >= 0; i--) {
				int curr = numArr[i];
				if (curr > max) {
					maxIndexPair = new MaxValIndexPair(curr, i);
					max = curr;
				}
				map.put(i, maxIndexPair);
			}

			for (int i = 0; i < numArr.length - 1; i++) {
				if (numArr[i] < map.get(i).max) {
					swap(numArr, i, map.get(i).index);
					break;
				}
			}
		}

		return Integer.parseInt(String.valueOf(numArr));
	}

	void swap(char[] numArr, int i, int j) {
		if (i != j) {
			char temp = numArr[i];
			numArr[i] = numArr[j];
			numArr[j] = temp;
		}
	}

	class MaxValIndexPair {
		int max;
		int index;

		MaxValIndexPair(int max, int index) {
			this.max = max;
			this.index = index;
		}
	}
}
