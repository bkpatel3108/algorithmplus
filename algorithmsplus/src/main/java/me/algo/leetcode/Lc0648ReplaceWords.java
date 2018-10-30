package me.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lc0648ReplaceWords {
	public String replaceWords(List<String> dict, String sentence) {
		Trie trie = generateTrie(dict);
		String result = Arrays.stream(sentence.split(" ")).map(word -> trie.getShorterWord(word))
				.collect(Collectors.joining(" "));

		return result;
	}

	Trie generateTrie(List<String> dict) {
		Trie trie = new Trie();
		dict.forEach(word -> trie.insertWord(word));
		return trie;
	}

	class Trie {
		Map<Character, Trie> map;
		boolean isWord;

		Trie() {
			this.map = new HashMap<>();
			isWord = false;
		}

		void insertWord(String word) {
			Trie curr = this;
			for (char c : word.toCharArray()) {
				curr = curr.map.computeIfAbsent(c, key -> new Trie());
			}
			curr.isWord = true;
		}

		String getShorterWord(String word) {
			if (!this.map.containsKey(word.charAt(0)))
				return word;

			StringBuilder result = new StringBuilder();
			Trie curr = this;
			for (char c : word.toCharArray()) {
				if (curr.isWord)
					return result.toString();

				if (!curr.map.containsKey(c)) {
					break;
				} else {
					result.append(String.valueOf(c));
					curr = curr.map.get(c);
				}
			}

			return word;
		}
	}
}
