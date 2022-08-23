package com.guardian.problemsolving.leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        int[] nums={-3,4,3,2};
        int pivot=2;
        Stream.of(pivotArray(nums,pivot)).forEach(e -> System.out.print(Arrays.toString(e) + " "));
    }
    //3n
    public static int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int i=0;
        int[] res=new int[n];
        for(int e:nums){
            if(e<pivot)
                res[i++]=e;
        }
        for(int e:nums){
            if(e==pivot)
                res[i++]=e;
        }
        for(int e:nums){
            if(e>pivot)
                res[i++]=e;
        }
        return res;
    }
    //2n
    public static int[] pivotArray2(int[] nums, int pivot) {
        int low = 0;
        int same = 0;
        int high;
        for (int n : nums)
        {
            if (n < pivot)
            {
                ++low;
            }
            else if (n == pivot)
            {
                ++same;
            }
        }
        int[] res=new int[nums.length];
        high = same + low;
        same = low;
        low = 0;
        for (int n : nums)
        {
            if (n < pivot)
            {
                res[low++] = n;
            }
            else if (n == pivot)
            {
                res[same++] = n;
            }
            else
            {
                res[high++] = n;
            }
        }
        return res;
    }
    //TLE
    public static int[] pivotArray3(int[] nums, int pivot) {
        int n=nums.length;
        int l=0,r=0,search=0;
        while(search<n){
            if(nums[search]<pivot){
                if(nums[l]>=pivot){
                    shiftElement(nums,l,search);
                    l++;r++;
                }
                else{
                    l=r=search;
                }
            }
            else if(nums[search]==pivot){
                if(nums[l]<pivot){
                    l=r=search;
                }
                else if(nums[l]>pivot){
                    shiftElement(nums,l,search);
                    r=l;
                }
                else{
                    shiftElement(nums,++r,search);
                }
            }
            else{
                if(nums[l]<pivot){
                    l=r=search;
                }
                else if(nums[l]>pivot){
                    r=search;
                }
            }
            search++;
        }
        return nums;
    }
    public static void shiftElement(int[] nums, int l, int r){
        while(r>l){
            int temp=nums[r-1];
            nums[r-1]=nums[r];
            nums[r]=temp;
            r--;
        }
    }
}
