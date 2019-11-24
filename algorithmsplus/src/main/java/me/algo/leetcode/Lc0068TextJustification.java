package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0068TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<String>();
		fullJustifyRec(words, maxWidth, 0, list);
		return list;
	}

	public void fullJustifyRec(String[] words, int maxWidth, int start, List<String> list) {
		int currWidth = 0;
		int end = start;
		while (end < words.length) {
			currWidth += words[end].length();
			if(end > start)
				currWidth += 1;
			if (currWidth > maxWidth) {
				currWidth -= words[end].length();
				if(end > start)
					currWidth -= 1;
				end--;
				break;
			}
			end++;
		}
		if (end >= words.length - 1) {
			list.add(leftAllignWords(words, start, words.length - 1, maxWidth));
			return;
		} else {
			list.add(addSpaces(words, start, end, currWidth, maxWidth));
			fullJustifyRec(words, maxWidth, end + 1, list);
		}
	}

	public String addSpaces(String[] words, int start, int end, int currWidth, int maxWidth) {
		int noOfWords = end - start + 1;
		if (noOfWords == 1)
			return leftAllignWords(words, start, end, maxWidth);
		int totalSpaces = maxWidth - currWidth;
		int gaps = noOfWords - 1;
		int adScBtwWd = totalSpaces % gaps;
		int noOfScBtwWd = (totalSpaces / gaps) + 1;
		char[] line = new char[maxWidth];
		char[] currWord = words[end--].toCharArray();
		int currWordIdx = currWord.length - 1;
		int currGap = gaps;
		for (int i = maxWidth - 1; i >= 0; i--) {
			if (currWordIdx == -1) {
				if (currGap == adScBtwWd)
					noOfScBtwWd++;
				for (int k = 0; k < noOfScBtwWd; k++) {
					line[i--] = ' ';
				}
				currWord = words[end--].toCharArray();
				currWordIdx = currWord.length - 1;
				currGap--;
			}
			line[i] = currWord[currWordIdx--];
		}
		return new String(line);

	}

	public String leftAllignWords(String[] words, int start, int end, int maxWidth) {
		StringBuffer sb = new StringBuffer();
		for (int j = start; j <= end; j++) {
			sb.append(words[j]);
			if (sb.length() < maxWidth)
				sb.append(' ');
		}
		for (int i = sb.length(); i < maxWidth; i++) {
			sb.append(' ');
		}
		return sb.toString();
	}
}
