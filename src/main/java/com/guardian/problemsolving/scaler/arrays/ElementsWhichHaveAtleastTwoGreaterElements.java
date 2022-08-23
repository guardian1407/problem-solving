package com.guardian.problemsolving.scaler.arrays;

public class ElementsWhichHaveAtleastTwoGreaterElements {
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4, 5};
        A = solve(A);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]);
        }
    }
    static int[] solve(int[] A) {
        int count = 0;
        int max = Math.max(A[0],A[1]);
        int secondMax = Math.min(A[0],A[1]);

        for(int i=2; i<A.length; i++) {
            if(A[i]>max){
                secondMax=max;
                max=A[i];
            }
            else if(A[i]<max && A[i]>secondMax){
                secondMax=A[i];
            }
        }

        for(int i=0; i<A.length; i++) {
            if(A[i]<secondMax)
                count++;
        }
        int[] arr = new int[count];
        count=0;

        for(int i=0; i<A.length; i++) {
            if(A[i]<secondMax)
                arr[count++]=A[i];
        }
        return arr;
    }
}
