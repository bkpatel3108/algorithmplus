package me.algo.leetcode;

public class Lc0069Sqrtx {
	public int mySqrt(int x) {
        if(x < 0)
            return -1;
        if(x == 0)
            return x;
        if(x <= 3)
            return 1;
        int left = 2;
        int right = x/2;
        int res = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            // to protect overflow mid*mid == x
            if(mid == x/mid)
                return mid;
            
            // to protect overflow mid*mid > x
            if(mid > x/mid)
                right = mid - 1;
            else{
                res = mid;
                left = mid + 1;
            }
                
        }
        
        return res;
    }
}
