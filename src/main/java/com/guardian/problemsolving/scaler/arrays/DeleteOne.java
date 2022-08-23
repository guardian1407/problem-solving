package com.guardian.problemsolving.scaler.arrays;

public class DeleteOne {
    public static void main(String[] args) {
        int[] A = {5, 15, 30};
        System.out.println(solve(A));
    }
    private static int solve(int[] A){
        int N=A.length;
        int[] prefixGCD=new int[N];
        int[] postfixGCD=new int[N];

        int gcd=0;
        for(int i=0;i<N;i++){
            gcd=gcd(gcd,A[i]);
            prefixGCD[i]=gcd;
        }

        gcd=0;
        for(int i=N-1;i>=0;i--){
            gcd=gcd(gcd,A[i]);
            postfixGCD[i]=gcd;
        }

        int maxGcd=postfixGCD[1];
        for(int i=1;i<N;i++){
            if(i==N-1)
                maxGcd=Math.max(maxGcd,prefixGCD[i-1]);
            else
                maxGcd=Math.max(maxGcd,gcd(prefixGCD[i-1],postfixGCD[i+1]));
        }
        return maxGcd;
    }
    private static int gcd(int A,int B){
        if(B==0)
            return A;
        return gcd(B,A%B);
    }
}
