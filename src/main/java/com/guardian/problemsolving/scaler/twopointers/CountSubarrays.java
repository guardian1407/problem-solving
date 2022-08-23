package com.guardian.problemsolving.scaler.twopointers;

import java.util.HashSet;
import java.util.Set;

public class CountSubarrays {
    public static void main(String[] args) {
        int[] A={3, 1, 3};
        System.out.println(solve(A));
    }
    private static int solve(int[] A) {
        long mod=(long)1e9+7;
        long count=0;
        int i=0,j=0;
        Set<Integer> set=new HashSet<>();

        while(j<A.length){
            if(i==j || !set.contains(A[j])){
                set.add(A[j]);
                j++;
            }
            else{
                long n=(j%mod-i%mod+mod)%mod;
                count+=(((n%mod*((n%mod+1%mod)%mod))%mod)/(2%mod))%mod;

                while(A[i]!=A[j]){
                    set.remove(A[i]);
                    i++;
                }
                set.remove(A[i]);
                i++;

                n=(j%mod-i%mod+mod)%mod;
                count=(count%mod-(((n%mod*((n%mod+1%mod)%mod))%mod)/(2%mod))%mod+mod)%mod;
            }
        }
        long n=(A.length%mod-i%mod+mod)%mod;
        count+=(((n%mod*((n%mod+1%mod)%mod))%mod)/(2%mod))%mod;

        count%=mod;
        while(count<0)
            count+=mod;
        count%=mod;
        return (int)count;
    }
}
