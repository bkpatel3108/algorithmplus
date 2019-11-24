package me.algo.leetcode;

import java.util.Stack;

public class Lc0150EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> operandStack = new Stack<Integer>();
        for(String token : tokens){         
            if(isOperator(token)){
                int secondOperand = operandStack.pop();
                int firstOperand = operandStack.pop();
                int result = applyOperator(firstOperand, secondOperand, token);
                operandStack.push(result);
            }else{
                operandStack.push(Integer.parseInt(token));
            }
        }
        return operandStack.pop();
        
    }
    
    private boolean isOperator(String token){
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
            return true;
        return false;
    }
    
    private int applyOperator(int firstOperand, int secondOperand, String operator){
        int result = 0;
        switch(operator){
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;       
        }
        return result;
    }
}
