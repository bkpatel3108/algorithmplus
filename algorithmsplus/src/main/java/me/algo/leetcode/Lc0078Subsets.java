package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0078Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        return subsetsHelper(nums, 0);
    }
    
    public List<List<Integer>> subsetsHelper(int[] nums, int i) {
        if(i==nums.length){
            List<Integer> list = new ArrayList<Integer>();
            List<List<Integer>> emptyList = new ArrayList<List<Integer>>();
            emptyList.add(list);
            return emptyList;
        }
        
        List<List<Integer>> subList = subsetsHelper(nums, i+1);
        List<List<Integer>> currList = new ArrayList<List<Integer>>(subList);

        for(List<Integer> list: subList){
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(nums[i]);
            currList.add(newList);
        }
        
        return currList;
    }
}
