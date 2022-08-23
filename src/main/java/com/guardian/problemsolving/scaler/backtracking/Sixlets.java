package com.guardian.problemsolving.scaler.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Sixlets {
    public static void main(String[] args){
        int[] A= {1, 2, 8};
        int B=2;
        System.out.print(solve(A,B));
    }
    private static int solve(int[] A, int B){
        return countSubsequence(A,B,0,new ArrayList<>(),0);
    }
    private static int countSubsequence(int[] A,int B,int index,List<Integer> list,int count){
        if(index==A.length){
            if(list.size()==B){
                int sum=list.stream().mapToInt(Integer::intValue).sum();
                if(sum<=1000)
                    count++;
            }
        }
        else{
            list.add(A[index]);
            count=countSubsequence(A,B,index+1,list,count);
            list.remove(list.size()-1);
            count=countSubsequence(A,B,index+1,list,count);
        }
        return count;
    }
    //------------------------------------------------------------------------------------------------------------------
//    private static int solve(int[] A, int B){
//        int N=A.length;
//        int[][] dp=new int[N][B+1];
//
//        for(int i=0;i<N;i++) {
//            for(int j=0;j<B+1;j++)
//                dp[i][j]=-1;
//        }
//        return countSubsequenceUtil(0,B,A,N,dp)-1;
//    }
//    static int countSubsequenceUtil(int ind,int sum,int[] A,int N,int[][] dp){
//        if (ind==N) return 1;
//        if (dp[ind][sum]!=-1) return dp[ind][sum];
//
//        if (A[ind] <= sum)
//            dp[ind][sum]=countSubsequenceUtil(ind+1,sum,A,N,dp)
//                    + countSubsequenceUtil(ind+1,sum-A[ind],A,N,dp);
//        else
//            dp[ind][sum]=countSubsequenceUtil(ind+1,sum,A,N,dp);
//
//        return dp[ind][sum];
//    }
    //------------------------------------------------------------------------------------------------------------------
//    private static int solve(int[] A, int B){
//        int N=A.length;
//        // Initialize a DP array
//        int [][]dp = new int[N][B + 1];
//        for(int i = 0; i < N; i++)
//        {
//            for(int j = 0; j < B + 1; j++)
//            {
//                dp[i][j] = -1;
//            }
//        }
//
//        // Return the result
//        return countSubsequenceUtil(0, B, A,
//                N, dp) - 1;
//    }
//    // Utility function to return the count
//// of subsequence in an array with sum
//// less than or equal to X
//    static int countSubsequenceUtil(int ind, int sum,
//                                    int []A, int N,
//                                    int [][]dp)
//    {
//
//        // Base condition
//        if (ind == N)
//            return 1;
//
//        // Return if the sub-problem
//        // is already calculated
//        if (dp[ind][sum] != -1)
//            return dp[ind][sum];
//
//        // Check if the current element is
//        // less than or equal to sum
//        if (A[ind] <= sum)
//        {
//
//            // Count subsequences excluding
//            // the current element
//            dp[ind][sum] = countSubsequenceUtil(
//                    ind + 1, sum,
//                    A, N, dp) +
//
//                    // Count subsequences
//                    // including the current
//                    // element
//                    countSubsequenceUtil(
//                            ind + 1,
//                            sum - A[ind],
//                            A, N, dp);
//        }
//        else
//        {
//
//            // Exclude current element
//            dp[ind][sum] = countSubsequenceUtil(
//                    ind + 1, sum,
//                    A, N, dp);
//        }
//
//        // Return the result
//        return dp[ind][sum];
//    }
}
