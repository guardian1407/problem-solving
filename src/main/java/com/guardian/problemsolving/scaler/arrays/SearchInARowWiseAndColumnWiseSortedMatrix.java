package com.guardian.problemsolving.scaler.arrays;

public class SearchInARowWiseAndColumnWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] A={{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        int B=2;
        System.out.print(solve(A,B));
    }
    private static int solve(int[][] A, int B) {
        int ans=Integer.MAX_VALUE;
        int i=0,j=A[0].length-1;

        while(i<A.length && j>=0){
            if(A[i][j]>B)
                j--;
            else if(A[i][j]<B)
                i++;
            else{
                ans=Math.min(ans,(i+1)*1009+(j+1));
                if(j-1>=0 && A[i][j-1]==B)
                    j--;
                else
                    i++;
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}
