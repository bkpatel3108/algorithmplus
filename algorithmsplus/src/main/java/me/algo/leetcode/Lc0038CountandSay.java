package me.algo.leetcode;

public class Lc0038CountandSay {
	public String countAndSay(int n) {
		StringBuffer sb = new StringBuffer("1");
		if (n == 1)
			return sb.toString();
		for (int i = 2; i <= n; i++) {
			int cnt = 1;
			StringBuffer nextsb = new StringBuffer("");
			for (int j = 1; j < sb.length(); j++) {
				if (sb.charAt(j) != sb.charAt(j - 1)) {
					nextsb.append("" + cnt + sb.charAt(j - 1));
					cnt = 1;
				} else
					cnt++;
			}
			nextsb.append("" + cnt + sb.charAt(sb.length() - 1));
			sb = nextsb;
		}
		return sb.toString();
	}
}
