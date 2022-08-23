package com.guardian.problemsolving.scaler.twopointers;

public class Array3Pointers {
    public static void main(String[] args) {
        int[] A={1, 4, 10};
        int[] B={2, 15, 20};
        int[] C={10, 12};
        System.out.print(minimize(A,B,C));
    }
    private static int minimize(final int[] A, final int[] B, final int[] C) {
        int ans=Integer.MAX_VALUE;
        int i=0,j=0,k=0;

        while(i<A.length && j<B.length && k<C.length){
            ans=Math.min(ans,Math.max(Math.abs(A[i]-B[j]),Math.max(Math.abs(C[k]-B[j]),Math.abs(A[i]-C[k]))));
            if(Math.abs(A[i]-B[j])>=Math.abs(C[k]-B[j]) && Math.abs(A[i]-B[j])>=Math.abs(A[i]-C[k])){
                if(A[i]<=B[j])
                    i++;
                else
                    j++;
            }
            else if(Math.abs(C[k]-B[j])>=Math.abs(A[i]-C[k])){
                if(C[k]<=B[j])
                    k++;
                else
                    j++;
            }
            else{
                if(A[i]<=C[k])
                    i++;
                else
                    k++;
            }
        }
        return ans;
    }
}
