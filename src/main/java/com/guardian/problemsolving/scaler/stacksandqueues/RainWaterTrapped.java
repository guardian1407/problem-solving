package com.guardian.problemsolving.scaler.stacksandqueues;

public class RainWaterTrapped {
    public static void main(String[] args){
        int[] A={0, 1, 0, 2};
        System.out.print(trap(A));
    }
    private static int trap(final int[] A){
        int N=A.length;
        int[] prefixMax=new int[N];
        int[] postfixMax=new int[N];
        int ans=0;

        prefixMax[0]=A[0];
        postfixMax[N-1]=A[N-1];

        for(int i=1;i<N;i++)
            prefixMax[i]=Math.max(A[i],prefixMax[i-1]);

        for(int i=N-2;i>=0;i--)
            postfixMax[i]=Math.max(A[i],postfixMax[i+1]);

        for(int i=0;i<N;i++)
            ans+=Math.min(prefixMax[i],postfixMax[i])-A[i];

        return ans;
    }
}
