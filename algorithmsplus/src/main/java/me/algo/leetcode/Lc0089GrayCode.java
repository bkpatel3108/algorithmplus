package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc0089GrayCode {
	public List<Integer> grayCode(int n) {
		if (n < 0)
			return null;

		if (n == 0)
			return new ArrayList<Integer>(Arrays.asList(0));

		// List<String> grayCodes = new ArrayList<String>();
		List<Integer> grayCodes = new ArrayList<Integer>();
		// grayCodes.add("0");
		// grayCodes.add("1");
		grayCodes.add(0);
		grayCodes.add(1);

		for (int i = 2; i <= n; i++) {
			int len = grayCodes.size();
			// for(int j=len-1; j>=0; j--){
			// grayCodes.add(grayCodes.get(j));
			// }

			// for(int j=0; j<len; j++){
			// grayCodes.add(j, "0" + grayCodes.get(j));
			// }

			// for(int j=len; j<len*2; j++){
			// grayCodes.add(j, "1" + grayCodes.get(j));
			// }
			for (int j = len - 1; j >= 0; j--) {
				grayCodes.add(grayCodes.get(j) + (int) Math.pow(2, i - 1));
			}
		}

		return grayCodes;
	}
}
