package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0118PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> outList = new ArrayList<List<Integer>>();
		if (numRows >= 1) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			outList.add(list);
		}
		if (numRows >= 2) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(1);
			outList.add(list);
		}
		for (int i = 3; i <= numRows; i++) {
			List<Integer> lastList = outList.get(i - 2);
			List<Integer> list = new ArrayList<Integer>();
			list.add(lastList.get(0));
			for (int j = 0; j < outList.size() - 1; j++) {
				list.add(lastList.get(j) + lastList.get(j + 1));
			}
			list.add(lastList.get(outList.size() - 1));
			outList.add(list);
		}
		return outList;
	}
}
