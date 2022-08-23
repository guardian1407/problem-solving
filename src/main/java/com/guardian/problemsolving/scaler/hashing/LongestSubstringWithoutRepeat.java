package com.guardian.problemsolving.scaler.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String A="AaaA";
        System.out.print(lengthOfLongestSubstring(A));
    }
    private static int lengthOfLongestSubstring(String A){
        int N=A.length();
        Map<Character,Integer> hm=new HashMap<>();
        int maxLength=1;
        int count=0;
        int lastIndex=-1;

        for(int i=0;i<N;i++){
            char val=A.charAt(i);
            if(hm.containsKey(val)){
                lastIndex=Math.max(lastIndex,hm.get(val));
                hm.put(val,i);
                count=i-lastIndex;
            }
            else{
                hm.put(val,i);
                count++;
            }
            maxLength=Math.max(maxLength,count);
        }
        return maxLength;
    }
}
