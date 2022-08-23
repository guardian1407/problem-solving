package com.guardian.problemsolving.scaler.math;

//Java heap space error if we do DFS
//Need to do DP ---> DP also giving java heap space error
//Need to use math combinatorics here
public class GridUniquePaths {
    public static void main(String[] args) {
        int A=5;
        int B=5;
        System.out.print(uniquePaths(A,B));
    }
    /*
    This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to move exactly m-1 steps down
    and n-1 steps right and these can be done in any order.

    For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order.
    That is nothing but a permutation problem. Denote down as 'D' and right as 'R', following is one of the path :-

    D R R R D R R R

    We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply
    following formula:-

    Total permutations = (m+n)! / (m! * n!)
     */
    private static int uniquePaths(int A, int B) {
        if(A == 1 || B == 1)
            return 1;
        A--;
        B--;
        if(A < B) {              // Swap, so that A is the bigger number
            A = A + B;
            B = A - B;
            A = A - B;
        }
        long res = 1;
        int j = 1;
        for(int i = A+1; i <= A+B; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
        return (int)res;
    }


//    private static int uniquePaths(int A, int B) {
//        int[][] matrix=new int[A][B];
//
//        for(int i=0;i<A;i++)
//            matrix[i][0]=1;
//
//        for(int i=0;i<B;i++)
//            matrix[0][i]=1;
//
//        for(int i=1;i<A;i++)
//            for(int j=1;j<B;j++)
//                matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
//
//        return matrix[A-1][B-1];
//    }


//    private static int uniquePaths(int A, int B) {
//        int[][] matrix=new int[A][B];
//        dfs(0,0,matrix);
//        return matrix[A-1][B-1];
//    }
//    private static void dfs(int row,int col,int[][] matrix){
//        if(row<matrix.length && col<matrix[0].length){
//            matrix[row][col]=matrix[row][col]+1;
//            dfs(row,col+1,matrix);
//            dfs(row+1,col,matrix);
//        }
//    }
}
