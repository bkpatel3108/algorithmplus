package me.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc0133CloneGraph {
	private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		for (UndirectedGraphNode neighbour : node.neighbors) {
			if (neighbour == node) {
				clone.neighbors.add(clone);
			} else {
				UndirectedGraphNode neighbourClone = null;
				if (map.containsKey(neighbour.label)) {
					neighbourClone = map.get(neighbour.label);
				} else {
					neighbourClone = cloneGraph(neighbour);
					map.put(neighbour.label, neighbourClone);
				}
				clone.neighbors.add(neighbourClone);
			}
		}
		return clone;
	}
}
