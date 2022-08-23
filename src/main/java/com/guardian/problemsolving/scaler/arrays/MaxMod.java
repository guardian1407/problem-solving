package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;
import java.util.Collections;

public class MaxMod {
    public static void main(String[] args) {
        int[] A={1, 2, 44, 3};
        System.out.print(solve(A));
    }
    private static int solve(int[] A) {
        A=Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int ans=0;
        int i=0;

        while(i<A.length){
            if(A[i]<A[0]){
                ans=A[i];
                break;
            }
            i++;
        }
        return ans;
    }
}
