package me.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Lc00210CourseSchedueII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> inMap = new HashMap<>();
		Map<Integer, Set<Integer>> outMap = new HashMap<>();
		List<Integer> courses = new ArrayList<>();

		IntStream.range(0, numCourses).forEach(i -> {
			inMap.put(i, new HashSet<Integer>());
			outMap.put(i, new HashSet<Integer>());
		});
		for (int[] dependency : prerequisites) {
			int u = dependency[0];
			int v = dependency[1];

			inMap.get(u).add(v);
			outMap.get(v).add(u);
		}

		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (Map.Entry<Integer, Set<Integer>> e : inMap.entrySet()) {
			if (e.getValue().isEmpty()) {
				queue.addLast(e.getKey());
			}
		}

		while (!queue.isEmpty()) {
			Integer curr = queue.removeFirst();
			courses.add(curr);

			for (Integer dependent : outMap.get(curr)) {
				inMap.get(dependent).remove(curr);
				if (inMap.get(dependent).isEmpty()) {
					queue.addLast(dependent);
				}
			}
		}
		if (courses.size() == numCourses) {
			return courses.stream().mapToInt(i -> i).toArray();
		} else {
			return new int[0];
		}
	}
}
