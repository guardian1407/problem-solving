package com.guardian.problemsolving.scaler.hashing;

import java.util.HashMap;
import java.util.Map;

public class IsDictionary {
    public static void main(String[] args) {
        String[] A={"hello", "scaler", "interviewbit"};
        String B="adhbcfegskjlponmirqtxwuvzy";
        System.out.print(solve(A,B));
    }
    private static int solve(String[] A, String B){
        Map<Character,Integer> cm=new HashMap<>();

        for(int i=0;i<B.length();i++)
            cm.put(B.charAt(i),i);

        for(int i=1;i<A.length;i++){
            String prev=A[i-1];
            String curr=A[i];
            boolean isValid=false;

            for(int j=0;j<Math.min(prev.length(),curr.length());j++){
                if(cm.get(prev.charAt(j))<cm.get(curr.charAt(j))){
                    isValid=true;
                    break;
                }
                else if(cm.get(prev.charAt(j))>cm.get(curr.charAt(j)))
                    return 0;
            }
            if(!isValid && prev.length()>curr.length())
                return 0;
        }
        return 1;
    }
}
