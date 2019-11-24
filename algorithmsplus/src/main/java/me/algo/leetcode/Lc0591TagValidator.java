package me.algo.leetcode;

import java.util.Stack;

public class Lc0591TagValidator {
	public boolean isValid(String code) {
		if (code == null || code.length() == 0)
			return false;
		char[] codeArr = code.toCharArray();
		Stack<String> stack = new Stack<String>();
		boolean atLeastOneTag = false;
		if (codeArr[0] != '<') {
			return false;
		}
		for (int i = 0; i < codeArr.length; i++) {
			if (codeArr[i] == '<') {
				int startIndex = i;
				boolean isStartTag = true;
				boolean isCdata = false;
				String tag = "";
				i++;
				if (codeArr[i] == '/') {
					isStartTag = false;
					i++;
				} else if (codeArr[i] == '!') {
					isCdata = true;
					i++;
				}

				if (isCdata) {
					if (i + 7 >= codeArr.length) {
						return false;
					}
					String cDataStr = new String(codeArr, i, 7);
					boolean cdataEnd = false;
					if (!cDataStr.equals("[CDATA["))
						return false;
					i += 7;
					while (i + 2 < codeArr.length) {
						if (codeArr[i] == ']' && codeArr[i + 1] == ']' && codeArr[i + 2] == '>') {
							cdataEnd = true;
							i += 2;
							break;
						}
						i++;
					}

					if (!cdataEnd)
						return false;

				} else {
					while (i < codeArr.length && codeArr[i] != '>') {
						// System.out.println(tag);
						if (i == codeArr.length - 1)
							return false;
						if (Character.isUpperCase(codeArr[i])) {
							tag += String.valueOf(codeArr[i]);
						} else {
							return false;
						}
						i++;
					}
					// System.out.println(tag);
					if (tag.length() < 1 || tag.length() > 9)
						return false;
					if (isStartTag) {
						if (stack.isEmpty() && startIndex != 0) {
							return false;
						}
						stack.push(tag);
						atLeastOneTag = true;
					} else {
						if (stack.isEmpty())
							return false;
						String startTag = stack.pop();
						if (stack.isEmpty() && i != codeArr.length - 1)
							return false;
						if (!startTag.equals(tag))
							return false;
					}
				}
			}
		}

		if (!stack.isEmpty()) {
			return false;
		}

		if (!atLeastOneTag) {
			return false;
		}
		return true;
	}
}
