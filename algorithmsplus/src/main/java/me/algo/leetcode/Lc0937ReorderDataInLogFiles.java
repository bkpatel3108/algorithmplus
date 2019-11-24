package me.algo.leetcode;

import java.util.Arrays;

public class Lc0937ReorderDataInLogFiles {
	public String[] reorderLogFiles(String[] logs) {
		if (logs == null || logs.length == 0)
			return logs;

		Arrays.sort(logs, (a, b) -> {
			a = a.substring(a.indexOf(" ") + 1);
			b = b.substring(b.indexOf(" ") + 1);
			char af = a.charAt(0);
			char bf = b.charAt(0);
			System.out.println(af);
			System.out.println(bf);

			if (Character.isLetter(af) && Character.isDigit(bf))
				return -1;
			if (Character.isDigit(af) && Character.isLetter(bf))
				return 1;
			if (Character.isDigit(af) && Character.isDigit(bf))
				return 0;
			return a.compareTo(b);
		});

		return logs;
	}
}
