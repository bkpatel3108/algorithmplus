package me.algo.leetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Lc0846HandOfStraights {
	public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0)
            return false;
        
        Arrays.sort(hand);
        
        List<Integer> list = Arrays.stream(hand).boxed().collect(Collectors.toCollection(LinkedList::new));
        Iterator<Integer> itr = list.iterator();
        
        int w = 0;
        Integer prev = null;
        while(itr.hasNext()){
            Integer curr = itr.next();
            if(prev == null || curr == prev+1){
                w++;
                itr.remove();
            }else if(curr.equals(prev)){
                continue;
            }else{
                System.out.println(curr + " " + prev);
                return false;
            }
            prev = curr;

            if(w == W){
                w = 0;
                itr = list.iterator();
                prev = null;
            }
        }
        System.out.println(list.size());
        return list.size() == 0;
    }
}
