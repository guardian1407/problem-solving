package com.guardian.problemsolving.scaler.greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructArray {
    public static void main(String[] args) {
        int A=2,B=2,C=3;
        Arrays.stream(solve(A,B,C)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(final int A, final int B, final int C) {
        int[] res=new int[A];
        int diff=C-B;
        List<Integer> factors=getFactors(diff);
        int minRight=Integer.MAX_VALUE;
        int minLeft=Integer.MAX_VALUE;
        int d=1;
        for(int factor:factors){
            if((A-1)*factor>=diff){
                int remainder=A-diff/factor-1;
                int min=B;
                int max=C;
                while(min-factor>0 && remainder>0){
                    min-=factor;
                    remainder--;
                }
                while(remainder>0){
                    max+=factor;
                    remainder--;
                }
                if(max<minRight || (max==minRight && min<minLeft)){
                    minLeft=min;
                    minRight=max;
                    d=factor;
                }
            }
        }
        return generateArray(minLeft,d,A);
    }
    private static List<Integer> getFactors(int num){
        List<Integer> res=new ArrayList<>();
        for(int i=1;i*i<=num;i++){
            if(num%i==0){
                res.add(i);
                if(i*i!=num)
                    res.add(num/i);
            }
        }
        return res;
    }
    private static int[] generateArray(int start, int diff, int size){
        int[] res=new int[size];
        for(int i=0;i<size;i++)
            res[i]=start+i*diff;
        return res;
    }
}
