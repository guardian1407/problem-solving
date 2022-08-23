package com.guardian.problemsolving.scaler.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxContinuousSeriesOf1s {
    public static void main(String[] args) {
        int[] A={1, 0, 0, 0, 1, 0, 1};
        int B=2;
        Arrays.stream(maxone(A,B)).forEach(e->System.out.print(e+" "));
    }
    private static int[] maxone(int[] A, int B) {
        List<Integer> ans=new ArrayList<>();
        int l=0,r=0;
        int minL=0,maxWindow=0;
        int zeroes=0;

        while(r<A.length){
            if(zeroes<=B){
                if(A[r]==0)
                    zeroes++;
                r++;
            }
            else{
                if(A[l]==0)
                    zeroes--;
                l++;
            }

            if((r-l>maxWindow)&&(zeroes<=B)){
                maxWindow=r-l;
                minL=l;
            }
        }

        for (int i=0;i<maxWindow;i++)
            ans.add(minL+i);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
