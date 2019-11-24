package me.algo.leetcode;

public class Lc0904FruitIntoBaskets {
	public int totalFruit(int[] tree) {
		Integer fv = null;
		Integer sv = null;
		Integer pv = null;
		int fc = 0;
		int sc = 0;
		int fl = 0;
		int sl = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < tree.length; i++) {
			if (fv == null || fv.equals(tree[i])) {
				fv = tree[i];
				fc++;
				fl = i;
			} else if (sv == null || sv.equals(tree[i])) {
				sv = tree[i];
				sc++;
				sl = i;
			} else {
				max = Math.max(fc + sc, max);
				if (pv.equals(sv)) {
					fc = sl - fl;
					fv = sv;
					fl = sl;
				} else {
					fc = fl - sl;
				}
				sv = tree[i];
				sc = 1;
				sl = i;
			}
			pv = tree[i];
		}
		max = Math.max(fc + sc, max);
		return max;
	}
}
