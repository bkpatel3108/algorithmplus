package me.algo.leetcode;

public class Lc0067AddBinary {
	public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int al = a.length();
        int bl = b.length();
        int ol = Math.max(al,bl);
        char[] out = new char[ol];
        char carry = '0';
        for(int i=al-1, j=bl-1, k=ol-1; i>= 0 || j>=0;){
            int count1s = 0;
            if(carry == '1')
                count1s++;
            if(i >= 0){
                if(ac[i] == '1')
                    count1s++;
                i--;
            }if(j >= 0){
                if(bc[j] == '1')
                    count1s++;
                j--;
            }
            switch(count1s){
                case 3:
                    out[k] = '1';
                    carry = '1';
                    break;
                case 2:
                    out[k] = '0';
                    carry = '1';
                    break;
                case 1:
                    out[k] = '1';
                    carry = '0';
                    break;
                case 0:
                    out[k] = '0';
                    carry = '0';
                    break;
            }
            k--;
        }
        if(carry == '1'){
            char[] newOut = new char[ol+1];
            for(int i=ol; i>=1; i--)
                newOut[i] = out[i-1];
            newOut[0] = '1';
            out = newOut;
        }
        
        return new String(out);
    }
}
