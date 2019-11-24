package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc0120Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        
        List<Integer> minPreRow = new ArrayList<Integer>();
        for(List<Integer> currList: triangle){
            if(minPreRow.isEmpty()){
                minPreRow = currList;
            }else{
                List<Integer> minCurrRow = new ArrayList<Integer>();
                for(int i=0; i<currList.size(); i++){
                    int currMin = currList.get(i);
                    if(i == 0){
                        currMin = currMin + minPreRow.get(i);
                    }else if(i == currList.size() - 1){
                        currMin = currMin + minPreRow.get(i-1);
                    }else{
                        currMin = currMin + Math.min(minPreRow.get(i-1), minPreRow.get(i));
                    }
                    minCurrRow.add(currMin);
                }
                minPreRow = minCurrRow;
            }
        }
        
        for(int curr: minPreRow){
            min = Math.min(min, curr);
        }
        return min;
    }
}
