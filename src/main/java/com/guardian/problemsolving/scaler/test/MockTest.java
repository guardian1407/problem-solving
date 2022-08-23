package com.guardian.problemsolving.scaler.test;

import java.util.Arrays;

public class MockTest {
    public static void main(String[] args) {
        int A=4;
        int[][] B = {{1, 2},{4, 4},{1, 3}};
        int[] C={1, 2, 3};

        int[] ans=solve(A,B,C);
        Arrays.stream(ans).forEach(e-> System.out.print(e+" "));
    }
    public static int[] solve(int A, int[][] B, int[] C) {
        int[] arr=new int[A];
        int[] ans=new int[C.length];

        for(int i=0;i<B.length;i++){
            int l=B[i][0]-1;
            int r=B[i][1]-1;

            arr[l]=arr[l]+1;
            if(r<arr.length-1)
                arr[r+1]=arr[r+1]-1;
        }

        for(int i=1;i<arr.length;i++)
            arr[i]=arr[i]+arr[i-1];

        Arrays.sort(arr);

        for(int i=0;i<C.length;i++){
            int index=findIndex(arr,C[i]);
            ans[i]=index!=-1 ? arr.length-index+1 : 0;
        }
        return ans;
    }
    private static int findIndex(int[] A, int k){
        int l=0; int r=A.length-1;
        int mid=(int)(l+((r-l)/2f));

        while(l<=r){
            if(A[mid]<k)
                l++;
            else if(A[mid]>k)
                r--;
            else{
                if((mid>0 && A[mid-1]<k) || mid==0)
                    return mid;
                else
                    r--;
            }
        }
        return -1;
    }
}
