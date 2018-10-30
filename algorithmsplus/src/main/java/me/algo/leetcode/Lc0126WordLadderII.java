package me.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Lc0126WordLadderII {
	Set<String> visited = new HashSet<>();

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> dic = new HashSet<>(wordList);

		// BFS
		Queue<Node> q = new LinkedList<>();

		Node beginNode = new Node(beginWord);
		q.offer(beginNode);
		List<List<String>> result = new LinkedList<>();
		boolean found = false;
		while (q.size() > 0) {
			int size = q.size();
			Map<String, Node> map = new HashMap<>();
			while (size-- > 0) {
				Node currWord = q.poll();
				if (!visited.contains(currWord.word)) {
					visited.add(currWord.word);
					LinkedList<Node> neigthbours = getNeighbours(currWord, dic, beginWord, map);
					if (neigthbours != null) {
						for (Node neighbour : neigthbours) {
							if (neighbour.word.equals(endWord)) {
								found = true;
							}
							q.offer(neighbour);
						}
					}
				}
			}
			if (found) {
				getNodeLists(result, new LinkedList<String>(), map.get(endWord));
				break;
			}
		}

		return result;
	}

	LinkedList<Node> getNeighbours(Node node, Set<String> dic, String beginWord, Map<String, Node> map) {
		LinkedList<Node> list = new LinkedList<>();
		for (int i = 0; i < node.word.length(); i++) {
			char[] wordArr = node.word.toCharArray();
			for (int j = 0; j < 26; j++) {
				wordArr[i] = (char) ((int) 'a' + j);
				String newWord = new String(wordArr);
				if (newWord.equals(node.word) == false && dic.contains(newWord) && visited.contains(newWord) == false) {
					Node newNode = map.computeIfAbsent(newWord, key -> new Node(newWord));
					newNode.addParent(node);
					list.addLast(newNode);
				}
			}
		}
		return list;
	}

	void getNodeLists(List<List<String>> result, LinkedList<String> currList, Node node) {
		currList.addFirst(node.word);
		if (node.parents.isEmpty()) {
			result.add(currList);
			return;
		}

		// if multiple parents then create separate linkedlist for each parent
		if (node.parents.size() > 0) {
			node.parents.forEach(parent -> getNodeLists(result, new LinkedList<String>(currList), parent));
		} else {
			getNodeLists(result, currList, node.parents.get(0));
		}

		currList.removeFirst();
	}

	class Node {
		String word;
		List<Node> parents;

		Node(String word) {
			this.word = word;
			this.parents = new ArrayList<>();
		}

		void addParent(Node parent) {
			parents.add(parent);
		}
	}
}
