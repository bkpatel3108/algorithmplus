package me.algo.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IbDistinctNumbersInWindow {
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		if (A == null || B <= 0)
			return null;

		int start = 0;
		int end = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> cntMap = new HashMap<Integer, Integer>();
		int cnt = 0;
		while (end < A.size()) {
			// if(cntMap.containsKey(A.get(end))){
			// cntMap.put(A.get(end), cntMap.get(A.get(end))+1);
			// }else{
			// cntMap.put(A.get(end), 1);
			// }
			cntMap.compute(A.get(end), (k, v) -> v == null ? 1 : v + 1);
			cnt++;
			if (cnt == B) {
				result.add(cntMap.size());
				cntMap.compute(A.get(start), (k, v) -> v == 1 ? null : v - 1);
				// cntMap.put(A.get(start), cntMap.get(A.get(start)) - 1);
				// if(cntMap.get(A.get(start)) == 0){
				// cntMap.remove(A.get(start));
				// }
				start++;
				cnt--;
			}
			end++;
		}
		return result;
	}
}
