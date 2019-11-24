package me.algo.leetcode;

import java.util.Iterator;
import java.util.List;

public class Lc0057InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int index = findInsertPlace(intervals, newInterval.start);
		intervals.add(index, newInterval);
		Integer mergeStart = findConfictStart(index, intervals, newInterval.start);
		Integer mergeEnd = findConfictEnd(index, intervals, newInterval.end);

		if (mergeStart == null) {
			mergeStart = index;
		}
		if (mergeStart != mergeEnd) {
			mergeConflicts(mergeStart, mergeEnd, intervals);
		}

		return intervals;
	}

	int findInsertPlace(List<Interval> intervals, int intervalStart) {
		int i = 0;
		while (i < intervals.size()) {
			if (intervals.get(i).start >= intervalStart) {
				break;
			}
			i++;
		}
		return i;
	}

	Integer findConfictStart(int index, List<Interval> intervals, int intervalStart) {
		Integer conflictStart = null;
		if (index > 0) {
			Interval prevInterval = intervals.get(index - 1);
			if (prevInterval.end >= intervalStart) {
				conflictStart = index - 1;
			}
		}
		return conflictStart;

	}

	int findConfictEnd(int index, List<Interval> intervals, int intervalEnd) {
		int i = index + 1;
		while (i < intervals.size()) {
			if (intervals.get(i).start > intervalEnd) {
				break;
			}
			i++;
		}
		return i - 1;
	}

	void mergeConflicts(int mergeStart, int mergeEnd, List<Interval> intervals) {
		int mergeStartTime = intervals.get(mergeStart).start;
		int mergeEndTime = intervals.get(mergeStart).end;
		Iterator<Interval> itr = intervals.iterator();
		int i = 0;
		while (itr.hasNext()) {
			Interval interval = itr.next();
			if (i >= mergeStart && i <= mergeEnd) {
				mergeEndTime = Math.max(mergeEndTime, interval.end);
				itr.remove();
			}
			i++;
		}
		Interval newInterval = new Interval(mergeStartTime, mergeEndTime);
		intervals.add(mergeStart, newInterval);
	}
}
