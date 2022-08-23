package com.guardian.problemsolving.leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        String boxes="001011";
        Stream.of(minOperations(boxes)).forEach(e -> System.out.print(Arrays.toString(e) + " "));
    }
    public static int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] res=new int[n];
        int ops=0;
        int count=0;
        for(int i=0;i<n;i++){
            String val=boxes.substring(i,i+1);
            ops+=count;
            res[i]=ops;
            if("1".equals(val)){
                count++;
            }
        }
        ops=0;
        count=0;
        for(int i=n-1;i>=0;i--){
            String val=boxes.substring(i,i+1);
            ops+=count;
            res[i]+=ops;
            if("1".equals(val)){
                count++;
            }
        }
        return res;
    }
}
