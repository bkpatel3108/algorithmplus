package me.algo.leetcode;

public class Lc0070ClimbingStairs {
	public int climbStairs(int n) {
        Integer[] ways = new Integer[n+1];
        return climbStairsRec(n, ways);
    }
    
    public int climbStairsRec(int n, Integer[] ways) {
        if(ways[n] != null){
            return ways[n];
        }
    
        int noOfWays = 0;
        if(n <= 2){
            noOfWays = n;
        }else{
            noOfWays = climbStairsRec(n-1, ways) + climbStairsRec(n-2, ways);
        }
        
        ways[n] = noOfWays;
        
        return noOfWays;
    }
}
