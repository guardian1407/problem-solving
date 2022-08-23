package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        int[] A={10, -1, 2, 3, -4, 100};
        Arrays.stream(maxset(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] maxset(int[] A){
        int N=A.length;
        int start=-1;
        long[] P=new long[N];
        long sum=0;

        for(int i=0;i<N;i++){
            if(A[i]>=0){
                start=i;
                break;
            }
        }

        if(start==-1)
            return new int[0];

        int end=start;

        for(int i=end;i<N;i++){
            if(A[i]>=0)
                end=i;
            else
                break;
        }

        for(int i=0;i<N;i++){
            sum+=A[i];
            P[i]=sum;
        }

        int currStart=end+1;
        int currEnd=currStart;

        for(int i=currStart;i<N;i++){
            if(A[i]>=0){
                if(A[currStart]<0)
                    currStart=i;
                currEnd=i;
            }

            if(A[i]<0 || i==N-1){
                if(A[currStart]>=0){
                    long prevSum=start==0 ? P[end] : P[end]-P[start-1];
                    long currSum=P[currEnd]-P[currStart-1];

                    if((currSum>prevSum) || (currSum==prevSum && currEnd-currStart>end-start)){
                        start=currStart;
                        end=currEnd;
                    }
                }
                currStart=i; currEnd=i;
            }
        }

        int[] ans=new int[end-start+1];

        for(int i=start;i<=end;i++)
            ans[i-start]=A[i];

        return ans;
    }
}
