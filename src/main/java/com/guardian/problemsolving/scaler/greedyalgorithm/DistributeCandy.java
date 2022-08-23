package com.guardian.problemsolving.scaler.greedyalgorithm;

public class DistributeCandy {
    public static void main(String[] args) {
        int[] A={1, 5, 2, 1};
        System.out.print(candy(A));
    }
    private static int candy(int[] A) {
        int N=A.length;
        int[] candy=new int[N];
        int ans=0;
        candy[0]=1;

        for(int i=1;i<N;i++){
            if(A[i]>A[i-1])
                candy[i]=candy[i-1]+1;
            else
                candy[i]=1;
        }

        ans=candy[N-1];
        for(int i=N-2;i>=0;i--){
            if(A[i]>A[i+1] && candy[i]<candy[i+1]+1)
                candy[i]=candy[i+1]+1;
            ans+=candy[i];
        }
        return ans;
    }
}
