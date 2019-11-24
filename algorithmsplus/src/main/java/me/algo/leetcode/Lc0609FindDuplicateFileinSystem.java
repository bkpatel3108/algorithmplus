package me.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc0609FindDuplicateFileinSystem {
	public List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> map = new HashMap<>();

		for (String path : paths) {
			String[] arr = path.split(" ");
			String dir = arr[0];
			for (int i = 1; i < arr.length; i++) {
				String file = arr[i];
				String filePath = file.substring(0, file.indexOf("("));
				String content = file.substring(file.indexOf("("), file.indexOf(")"));
				map.putIfAbsent(content, new ArrayList<String>());
				map.get(content).add(dir + "/" + filePath);
			}
		}

		List<List<String>> list = new ArrayList<>();
		for (List value : map.values()) {
			if (value.size() > 1) {
				list.add(value);
			}
		}
		return list;
	}
}
