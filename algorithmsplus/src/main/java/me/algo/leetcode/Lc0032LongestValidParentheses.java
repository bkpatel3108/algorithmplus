package me.algo.leetcode;

import java.util.Stack;

public class Lc0032LongestValidParentheses {
	public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else{
                int curr = 0;
                if(!stack.isEmpty()){
                    if(s.charAt(stack.peek()) == '('){
                        stack.pop();
                        if(stack.isEmpty())
                            curr = i+1;
                        else
                            curr = i-stack.peek();
                    }else{
                        stack.push(i);
                    }  
                }else{
                   stack.push(i); 
                }
                max = Math.max(curr, max);
            }         
        }
        return max;
        
    }
}
