package com.guardian.problemsolving.test2;

public class Test2 {
    public static void main(String[] args) {
        int[] A={2,1,3};
        System.out.println(solve(A));
    }
    private static String solve(int[] A){
        double res=0;
        int prev=0;
        for(int i=0;i<A.length;i++){
            int diff=Math.abs(A[i]-prev);
            int rect=Math.max(A[i],prev);
            double area=rect-(diff/2.0);
            res+=area;
            prev=A[i];
        }
        res+=A[A.length-1]/2.0;
        return String.valueOf(res);
    }
}
