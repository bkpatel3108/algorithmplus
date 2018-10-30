package me.algo.leetcode;

import java.util.Arrays;

public class Lc0684RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {

		if (edges == null || edges.length == 0)
			return new int[] { -1, -1 };

		UnionFind uf = new UnionFind();

		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];

			int uFind = uf.find(u);
			int vFind = uf.find(v);

			if (uFind == vFind) {
				return edge;
			} else {
				uf.union(uFind, vFind);
			}
		}

		return new int[] { -1, -1 };
	}

	class UnionFind {
		int[] parents;
		int[] ranks;

		UnionFind() {
			this.parents = new int[1001];
			this.ranks = new int[1001];
			Arrays.fill(parents, -1);
			Arrays.fill(ranks, -1);
		}

		void union(int x, int y) {
			if (find(x) == find(y))
				return;

			if (ranks[x] >= ranks[y]) {
				parents[y] = x;
				ranks[x] += ranks[y];
			} else {
				parents[x] = y;
				ranks[y] += ranks[x];
			}
		}

		int find(int c) {
			int p = c;
			while (parents[p] != -1) {
				p = parents[p];
			}
			parents[c] = p != c ? p : -1;
			return p;
		}
	}
}
