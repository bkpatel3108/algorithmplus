package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc0056MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		if (intervals == null || intervals.size() == 0)
			return intervals;
		List<Interval> result = new ArrayList<Interval>();
		Interval firstInterval = intervals.get(0);
		Integer start = firstInterval.start;
		Integer end = firstInterval.end;
		for (int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval.start > end) {
				result.add(new Interval(start, end));
				start = interval.start;
			}
			end = Math.max(end, interval.end);
		}
		result.add(new Interval(start, end));
		return result;
	}
}
