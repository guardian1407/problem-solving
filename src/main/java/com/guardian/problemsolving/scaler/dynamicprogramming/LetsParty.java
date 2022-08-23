package com.guardian.problemsolving.scaler.dynamicprogramming;

public class LetsParty {
    public static void main(String[] args) {
        int A=5;
        System.out.print(solve(A));
    }
    private static int solve(int A){
        if(A==1)
            return 1;
        else if(A==2)
            return 2;
        else{
            long mod=(long)1e4+3;
            long first=1;
            long second=2;

            for(int i=3;i<=A;i++){
                long temp=second;
                second=(((first%mod)*((i%mod-1%mod)%mod))%mod+second%mod)%mod;
                first=temp;
            }
            second%=mod;
            while(second<0)
                second+=mod;
            second%=mod;
            return (int)second;
        }
    }
}
