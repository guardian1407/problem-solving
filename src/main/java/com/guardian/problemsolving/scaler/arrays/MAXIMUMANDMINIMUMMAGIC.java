package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class MAXIMUMANDMINIMUMMAGIC {
    public static void main(String[] args) {
        int[] A={3, 11, -1, 5};
        Arrays.stream(solve(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(int[] A) {
        long mod=(long)1e9+7;
        int[] res=new int[2];
        Arrays.sort(A);
        long max=0;
        long min=0;
        int i=0,j=A.length-1;
        while(i<j){
            max+=Math.abs(A[i]-A[j])%mod;
            i++;j--;
        }
        i=0;j=1;
        while(j<A.length){
            min+=Math.abs(A[i]-A[j])%mod;
            i+=2;j+=2;
        }
        max%=mod;
        min%=mod;
        while(max<0)
            max+=mod;
        while(min<0)
            min+=mod;
        max%=mod;
        min%=mod;
        res[0]=(int)max;
        res[1]=(int)min;
        return res;
    }
}
