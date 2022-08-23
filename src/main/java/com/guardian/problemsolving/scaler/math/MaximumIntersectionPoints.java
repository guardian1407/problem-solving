package com.guardian.problemsolving.scaler.math;

public class MaximumIntersectionPoints {
    public static void main(String[] args) {
        int A=2;
        int B=2;
        System.out.print(getIntersection(A,B));
    }
    private static int getIntersection(int A, int B){
        return ((A*(A-1))/2)+(B*(2*A+B-1));
    }
}
