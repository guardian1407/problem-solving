package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;

public class KthRowOfPascalsTriangle {
    public static void main(String[] args) {
        int A=3;
        Arrays.stream(getRow(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] getRow(int A) {
        int[] res=new int[A+1];
        res[0]=1;
        for(int i=1;i<=A;i++){
            int t1=res[0];
            for(int j=1;j<=i;j++){
                int t2=res[j];
                res[j]=t1+res[j];
                t1=t2;
            }
        }
        return res;
    }
}
