package me.algo.leetcode;

public class Lc0066PlusOne {
	public int[] plusOne(int[] digits) {
        int[] output = new int[digits.length];
        int carry = 0;
        for(int i=digits.length-1; i>=0; i--){
            int digit = digits[i];
            if(i == digits.length-1)
                digit +=1;
            digit += carry;
            output[i] = digit % 10;
            carry = digit / 10;
        }
        if(carry > 0){
            int[] newOutput = new int[digits.length + 1];
            for(int i=digits.length-1; i>=0; i--){
                newOutput[i+1] = output[i];
            }
            newOutput[0] = carry;
            output = newOutput;
        }
        
        return output;
    }
}
