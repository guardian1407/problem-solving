package com.guardian.problemsolving.scaler.arrays;

public class PatternPrinting2 {
    public static void main(String[] args) {
        int A=10;
        int[][] arr = solve(A);
        for(int i=0;i<A;i++){
            for(int j=0;j<A;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }

    static int[][] solve(int A) {
        int[][] arr = new int[A][A];
        for(int i=0;i<A;i++){
            for(int j=0;j<A;j++){
                if(i+j<A-1)
                    arr[i][j]=0;
                else
                    arr[i][j]=A-j;
            }
        }
        return arr;
    }
}
