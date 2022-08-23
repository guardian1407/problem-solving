package com.guardian.problemsolving.scaler.binarysearch;

import java.util.ArrayList;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] A={12, 34, 67, 90};
        int B=2;
        System.out.println(books(A,B));
    }
    private static int books(int[] A, int B) {
        int N=A.length;
        int sum=0;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            sum+=A[i];
            max=Math.max(max,A[i]);
        }
        int l=max;
        int r=sum;

        while(r-l>1){
            int mid=(l+r)/2;

            if(check(A,B,mid))
                r=mid;
            else
                l=mid+1;
        }
        return check(A,B,l) ? l : (check(A,B,r) ? r : -1);
    }
    private static boolean check(int[] A,int B,int k){
        int N=A.length;
        int sum=0;
        int l=0;

        while(B>0 && l<N){
            sum+=A[l];

            if(sum>k){
                if(A[l]>k)
                    return false;
                else
                    sum=A[l];
                B--;
            }
            else
                l++;
        }
        return l>=N;
    }
    //-------------------------------------------------------------------------------------------------------------------
    public int books(ArrayList<Integer> A, int B) {
        return findPages(A, A.size(), B);
    }

    public int findPages(ArrayList<Integer> A, int totalStudents, int allowedStudents) {
        long sum = 0;
        if (totalStudents < allowedStudents) return -1;
        for (int i=0; i<totalStudents; i++) {
            sum += A.get(i);
        }

        int start = 0;
        int end = (int)sum;
        int res = Integer.MAX_VALUE;

        while(start <= end) {
            int mid = (start + end)/2;
            if (isPossible(A, totalStudents, allowedStudents, mid)) {
                res = Math.min(res, mid);
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        return res;
    }

    public boolean isPossible(ArrayList<Integer> A, int totalStudents, int allowedStudents, int currMin) {
        int studentsReq = 1;
        int currSum = 0;

        for (int i=0; i<totalStudents; i++) {
            if (A.get(i) > currMin) {
                return false;
            }
            if (currSum + A.get(i) > currMin) {
                studentsReq++;
                currSum = A.get(i);
                if (studentsReq > allowedStudents) {
                    return false;
                }
            }
            else {
                currSum += A.get(i);
            }
        }

        return true;
    }
}
