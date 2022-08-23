package com.guardian.problemsolving.scaler.arrays;

public class MultiplyPrevAndNext {
    public static void main(String[] args) {
        int[] A={1,2,-3,4,6};
        A = solve(A);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i] + " ");
        }
    }
    static int[] solve(int[] A) {
        int[] B = new int[A.length];
        int prevIndex;
        int nextIndex;
        for(int i=0;i<A.length;i++){
            if(i==0 && A.length==1){
                prevIndex=0;
                nextIndex=0;
            }
            else if(i==0){
                prevIndex=0;
                nextIndex=1;
            }
            else if(i==A.length-1){
                prevIndex=A.length-2;
                nextIndex=A.length-1;
            }
            else{
                prevIndex=i-1;
                nextIndex=i+1;
            }
            B[i]=A[prevIndex]*A[nextIndex];
        }
        return B;
    }
}
