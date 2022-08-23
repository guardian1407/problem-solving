package com.guardian.problemsolving.scaler.arrays;

public class PatternPrinting1 {
    public static void main(String[] args) {
        int A=4;
        int[][] arr = solve1(A);
        for(int i=0;i<A;i++){
            int[] arr1 = arr[i];
            for(int j=0;j<arr1.length;j++){
                System.out.print(arr1[j]);
            }
            System.out.println("");
        }
    }
    static int[][] solve(int A) {
        int[][] arr = new int[A][];
        for(int i=0;i<A;i++){
            int[] arr1 = new int[i+1];
            for(int j=0; j<=i; j++){
                arr1[j] = j+1;
            }
            arr[i] = arr1;
        }
        return arr;
    }
    static int[][] solve1(int A) {
        int[][] arr = new int[A][A];
        for(int i=0;i<A;i++){
            for(int j=0; j<=i; j++){
                arr[i][j] = j+1;
            }
        }
        return arr;
    }
}
