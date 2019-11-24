package me.algo.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Lc0934ShortestBridge {
	public int shortestBridge(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0)
			return -1;

		Set<String> set1 = new HashSet<>(); // First island
		Set<String> set2 = new HashSet<>(); // second island
		boolean[][] visited = new boolean[A.length][A[0].length];
		int cnt = 0;
		generateIslands(A, visited, set1, set2);

		Queue<String> q = set1.stream().collect(Collectors.toCollection(LinkedList::new));

		while (q.size() > 0) {
			int size = q.size();
			while (size-- > 0) {
				String curr = q.poll();
				int r = Integer.parseInt(curr.split("-")[0]);
				int c = Integer.parseInt(curr.split("-")[1]);
				if (checkNeighbour(A, visited, r, c - 1, set2, q) || checkNeighbour(A, visited, r, c + 1, set2, q)
						|| checkNeighbour(A, visited, r - 1, c, set2, q)
						|| checkNeighbour(A, visited, r + 1, c, set2, q)) {
					return cnt;
				}
			}
			cnt++;
		}
		return cnt;
	}

	boolean checkNeighbour(int[][] A, boolean[][] visited, int r, int c, Set<String> set, Queue<String> q) {
		if (r < 0 || r >= A.length || c < 0 || c >= A[0].length) {
			return false;
		}
		if (set.contains(r + "-" + c)) {
			return true;
		}
		if (!visited[r][c]) {
			visited[r][c] = true;
			q.offer(r + "-" + c);
		}
		return false;
	}

	void generateIslands(int[][] A, boolean[][] visited, Set<String> set1, Set<String> set2) {
		boolean flag = false;
		for (int r = 0; r < A.length; r++) {
			for (int c = 0; c < A[0].length; c++) {
				if (visited[r][c] == false && A[r][c] == 1) {
					if (!flag) {
						dfs(A, visited, r, c, set1);
						flag = true;
					} else {
						dfs(A, visited, r, c, set2);
						return;
					}
				}
			}
		}
	}

	void dfs(int[][] A, boolean[][] visited, int r, int c, Set<String> set) {
		if (r < 0 || r >= A.length || c < 0 || c >= A[0].length || visited[r][c])
			return;
		if (A[r][c] == 1) {
			visited[r][c] = true;
			set.add(r + "-" + c);
			dfs(A, visited, r, c - 1, set);
			dfs(A, visited, r, c + 1, set);
			dfs(A, visited, r - 1, c, set);
			dfs(A, visited, r + 1, c, set);
		}
	}
}
