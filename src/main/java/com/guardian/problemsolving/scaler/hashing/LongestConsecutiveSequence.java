package com.guardian.problemsolving.scaler.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args){
        int[] A= {100, 4, 200, 1, 3, 2};
        System.out.print(longestConsecutive(A));
    }
    private static int longestConsecutive(final int[] A){
        int N=A.length;
        Set<Integer> hs=new HashSet<>();
        int ans=1;

        for(int i=0;i<N;++i)
            hs.add(A[i]);

        for(int i=0;i<N;++i){
            if(!hs.contains(A[i]-1)){
                int count=1;
                int next=A[i]+1;

                while(hs.contains(next)){
                    next++;
                    count++;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}
