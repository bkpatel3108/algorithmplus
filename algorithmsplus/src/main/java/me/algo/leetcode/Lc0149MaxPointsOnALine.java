package me.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc0149MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			Point p = points[i];
			// Map<Double, Integer> map = new HashMap<>();
			Map<String, Integer> map = new HashMap<>();
			int currMax = 0;
			int verticalPoints = 0;
			int overlapping = 0;
			for (int j = i + 1; j < points.length; j++) {
				Point q = points[j];
				int x = (q.x - p.x);
				int y = (q.y - p.y);

				if (p.x == q.x && p.y == q.y) {
					overlapping++;
					continue;
				}
				if (x == 0) {
					verticalPoints++;
					continue;
				}

				// double slope = y/(double)x + 0.0; // to get rid of -0.0

				// double slope will not work for testcase
				// [[0,0],[94911151,94911150],[94911152,94911151]]
				// Anyway, it is antipattern to use equals to on double/float
				// without specifying precision.
				// we have to use y/x as map key. and use gcd to divide them

				int gcd = getGCD(x, y);

				String slope = (y / gcd) + "/" + (x / gcd);
				currMax = Math.max(currMax, map.compute(slope, (k, v) -> v == null ? 1 : v + 1));
			}
			max = Math.max(max, currMax + overlapping + 1);
			max = Math.max(max, verticalPoints + 1);
		}
		return max;
	}

	int getGCD(int a, int b) {
		return b == 0 ? a : getGCD(b, a % b);
	}
}
