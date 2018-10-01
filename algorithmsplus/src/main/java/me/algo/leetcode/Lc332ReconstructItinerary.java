package me.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Lc332ReconstructItinerary {
	// public List<String> findItinerary(String[][] tickets) {
	// LinkedList<String> path = new LinkedList<>();
	// Map<String, List<String>> graph = new HashMap<>();

	// Arrays.stream(tickets)
	// .forEach(ticket -> graph.computeIfAbsent(ticket[0], key -> new
	// LinkedList<String>()).add(ticket[1]));

	// graph.forEach((key, value) -> Collections.sort(value));

	// dfs(graph, "JFK", path);

	// return path;
	// }

	// void dfs(Map<String, List<String>> graph, String curr, LinkedList<String>
	// path){
	// List<String> currAdjList = graph.get(curr);
	// if(currAdjList != null){
	// while(currAdjList.size() > 0){
	// String adj = currAdjList.remove(0);
	// dfs(graph, adj, path);
	// }
	// }
	// path.addFirst(curr);
	// }

	public List<String> findItinerary(String[][] tickets) {
		LinkedList<String> path = new LinkedList<>();
		Map<String, PriorityQueue<String>> graph = new HashMap<>();

		Arrays.stream(tickets)
				.forEach(ticket -> graph.computeIfAbsent(ticket[0], key -> new PriorityQueue<String>()).add(ticket[1]));

		dfs(graph, "JFK", path);

		return path;
	}

	void dfs(Map<String, PriorityQueue<String>> graph, String curr, LinkedList<String> path) {
		PriorityQueue<String> currAdjList = graph.get(curr);
		if (currAdjList != null) {
			while (currAdjList.size() > 0) {
				String adj = currAdjList.poll();
				dfs(graph, adj, path);
			}
		}
		path.addFirst(curr);
	}
}
