package com.guardian.problemsolving.scaler.dynamicprogramming;

public class Stairs {
    public static void main(String[] args) {
        int A=26;
        System.out.print(climbStairs(A));
    }
    private static int climbStairs(int A) {
        if(A==1)
            return 1;
        else if(A==2)
            return 2;
        else{
            int[] ways=new int[A];
            ways[0]=1;
            ways[1]=2;

            for(int i=2;i<A;i++)
                ways[i]=ways[i-1]+ways[i-2];

            return ways[A-1];
        }
    }
    private static int climbStairs1(int A) {
        if(A==1)
            return 1;
        else if(A==2)
            return 2;
        else{
            int first=1;
            int second=2;

            for(int i=2;i<A;i++){
                int temp=second;
                second+=first;
                first=temp;
            }
            return second;
        }
    }
    private static int climbStairs2(int A) {
        int[] ways=new int[A];
        for(int i=0;i<A;i++)
            ways[i]=-1;
        return climbStairs2Helper(A,ways);
    }
    private static int climbStairs2Helper(int A,int[] ways){
        if(A==1){
            ways[0]=1;
            return 1;
        }
        else if(A==2){
            ways[1]=2;
            return 2;
        }
        else{
            if(ways[A-1]==-1)
                ways[A-1]=climbStairs2Helper(A-1,ways)+climbStairs2Helper(A-2,ways);
            return ways[A-1];
        }
    }
}
