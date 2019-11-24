package me.algo.leetcode;

import java.util.Stack;

public class Lc0071SimplifyPath {
	public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        char[] pathArr = path.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<path.length(); i++){
            char c = pathArr[i];
            if(c=='/' || i==path.length()-1){
                if(c != '/')
                    sb.append(c);
                if(sb.length() > 0){
                    String dir = sb.toString();
                    if(dir.equals("..")){
                        if(!stack.isEmpty())
                            stack.pop();
                    }else if(!dir.equals(".")){
                        stack.push(dir);
                    }
                    sb = new StringBuffer();
                }
            }
            else{
                sb.append(c);   
            }       
        }
            
        if(stack.isEmpty())
            return "/";
        
        String result = "";
        while(!stack.isEmpty()){
            String dir = stack.pop();
            result = "/" + dir + result;
        }
        
        return result;
    }
}
