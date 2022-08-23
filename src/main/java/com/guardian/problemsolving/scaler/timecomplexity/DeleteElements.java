package com.guardian.problemsolving.scaler.timecomplexity;

public class DeleteElements {
    public static void main(String[] args){
        int[] A= {7, 2, 5};
        System.out.print(solve(A));
    }
    private static int solve(int[] A){
        int gcd=A[0];

        for(int i=1;i<A.length;i++)
            gcd=gcd(gcd,A[i]);

        return gcd>1 ? -1 : 0;
    }
    private static int gcd(int A,int B){
        if(B==0)
            return A;
        return gcd(B,A%B);
    }
}
