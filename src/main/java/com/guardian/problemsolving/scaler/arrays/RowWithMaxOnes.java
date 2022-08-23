package com.guardian.problemsolving.scaler.arrays;

public class RowWithMaxOnes {
    public static void main(String[] args) {
        int[][] A={{0,0,0,0,1,1},{0,0,0,1,1,1},{0,0,1,1,1,1},{0,1,1,1,1,1}};
        System.out.print(solve(A));
    }
    static int solve(int[][] A) {
        int row=0;
        int maxOnes=0;

        for(int i=0;i<A.length;i++){
            int j=0;
            while(j<A[i].length && A[i][j]==0)
                j++;
            int ones=A[i].length-j;
            if(ones>maxOnes){
                maxOnes=ones;
                row=i;
            }
        }
        return row;
    }
}
