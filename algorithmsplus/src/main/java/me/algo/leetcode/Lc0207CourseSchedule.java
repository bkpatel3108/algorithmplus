package me.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lc0207CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : prerequisites) {
			int u = edge[0];
			int v = edge[1];
			graph.putIfAbsent(u, new ArrayList<Integer>());
			graph.get(u).add(v);
		}

		Set<Integer> visited = new HashSet<>();
		Set<Integer> visiting = new HashSet<>();
		// perform dfs to track cycle
		for (int u : graph.keySet()) {
			if (hasCycle(graph, u, visited, visiting)) {
				return false;
			}
		}
		return true;
	}

	boolean hasCycle(Map<Integer, List<Integer>> graph, int u, Set<Integer> visited, Set<Integer> visiting) {
		if (visiting.contains(u))
			return true;

		if (visited.contains(u))
			return false;

		visiting.add(u);
		List<Integer> adjList = graph.get(u);
		if (adjList != null) {
			for (Integer v : adjList) {
				if (hasCycle(graph, v, visited, visiting)) {
					return true;
				}
			}
		}
		visited.add(u);
		visiting.remove(u);
		return false;
	}
}
