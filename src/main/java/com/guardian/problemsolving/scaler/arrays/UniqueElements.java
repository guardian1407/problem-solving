package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueElements {
    public static void main(String[] args){
        int[] A= {3,2,1,2,1,7};
        System.out.print(solve(A));
    }
    //optimal
    private static int solve(int[] A){
        Arrays.sort(A);
        int ans = 0, taken = 0;

        for (int i = 1; i < A.length; ++i) {
            if (A[i-1] == A[i]) {
                taken++;
                ans -= A[i];
            } else {
                int give = Math.min(taken, A[i] - A[i-1] - 1);
                ans += give * (give + 1) / 2 + give * A[i-1];
                taken -= give;
            }
        }

        if (A.length > 0)
            ans += taken * (taken + 1) / 2 + taken * A[A.length - 1];

        return ans;
    }

    //not optimal
    private static int solve1(int[] A){
        int N=A.length;
        Set<Integer> hs=new HashSet<>();
        int count=0;

        for(int i=0;i<N;i++){
            int val=A[i];

            while(hs.contains(val)){
                val++;
                count++;
            }
            hs.add(val);
        }
        return count;
    }
}
