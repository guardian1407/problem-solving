package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class AlternatePositiveAndNegativeElements {
    public static void main(String[] args) {
        int[] A={-1, -2, -3, 4, 5};
        Arrays.stream(solve(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(int[] A) {
        int N=A.length;
        int flag=-1;

        for(int i=0;i<N-1;i++){
            int index=i+1;
            if(flag==1 && A[i]<0){
                while(index<N && A[index]<0)
                    index++;

                if(index<N)
                    shiftArray(A,i,index);
                else
                    break;
            }
            else if(flag==-1 && A[i]>=0){
                while(index<N && A[index]>=0)
                    index++;

                if(index<N)
                    shiftArray(A,i,index);
                else
                    break;
            }
            flag=-flag;
        }
        return A;
    }
    private static void shiftArray(int[] A,int start,int end){
        int val=A[end];
        if(end-start>=0) System.arraycopy(A,start,A,start+1,end-start);
        A[start]=val;
    }
}
