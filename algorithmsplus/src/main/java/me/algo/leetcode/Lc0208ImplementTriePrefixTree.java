package me.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc0208ImplementTriePrefixTree {
	private Map<Character, Lc0208ImplementTriePrefixTree> childTries;
	private boolean isWord;

	/** Initialize your data structure here. */
	public Lc0208ImplementTriePrefixTree() {
		this.childTries = new HashMap<>();
		this.isWord = false;
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Lc0208ImplementTriePrefixTree curr = this;
		for (char c : word.toCharArray()) {
			Lc0208ImplementTriePrefixTree trieNode = curr.childTries.get(c);
			if (trieNode == null) {
				trieNode = new Lc0208ImplementTriePrefixTree();
				curr.childTries.put(c, trieNode);
			}
			curr = trieNode;
		}
		curr.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Lc0208ImplementTriePrefixTree curr = this;
		for (char c : word.toCharArray()) {
			curr = curr.childTries.get(c);
			if (curr == null)
				return false;
		}
		return curr.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		Lc0208ImplementTriePrefixTree curr = this;
		for (char c : prefix.toCharArray()) {
			curr = curr.childTries.get(c);
			if (curr == null)
				return false;
		}
		return true;
	}
}
