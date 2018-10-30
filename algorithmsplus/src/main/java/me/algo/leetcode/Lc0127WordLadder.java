package me.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Lc0127WordLadder {
	Set<String> visited = new HashSet<String>();
	Set<String> wordSet;

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		wordSet = new HashSet<String>(wordList);
		LinkedList<String> currentList = new LinkedList<String>();
		LinkedList<String> nextList = new LinkedList<String>();
		currentList.addLast(beginWord);
		int distance = 1;
		while (!currentList.isEmpty()) {
			String current = currentList.removeFirst();
			visited.add(current);
			List<String> neighbours = getNeighbours(current);
			if (neighbours != null) {
				for (String neighbour : neighbours) {
					if (endWord.equals(neighbour)) {
						return distance + 1;
					}
					if (!visited.contains(neighbour)) {
						nextList.addLast(neighbour);
					}
				}
			}
			if (currentList.isEmpty()) {
				distance++;
				currentList = nextList;
				nextList = new LinkedList<String>();
			}

		}
		return 0;
	}

	List<String> getNeighbours(String word) {
		List<String> neighbours = new ArrayList<String>();

		for (int i = 0; i < word.length(); i++) {
			char[] wordChArr = word.toCharArray();
			for (int j = 'a'; j <= 'z'; j++) {
				wordChArr[i] = (char) j;
				String newWord = new String(wordChArr);
				if (wordSet.contains(newWord) && !visited.contains(newWord)) {
					neighbours.add(newWord);
				}
			}
		}

		return neighbours;
	}
}
