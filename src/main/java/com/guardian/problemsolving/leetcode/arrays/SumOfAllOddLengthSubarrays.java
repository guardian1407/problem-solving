package com.guardian.problemsolving.leetcode.arrays;

public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        int[] arr={1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(arr));
    }
    public static int sumOddLengthSubarrays(int[] arr) {
        int res = 0, n = arr.length;
        for (int i = 0; i < n; ++i) {
            res += ((i + 1) * (n - i) + 1) / 2 * arr[i];
        }
        return res;
    }
    /*
     * Consider the subarray that contains A[i],
     * we can take 0,1,2..,i elements on the left,
     * from A[0] to A[i],
     * we have i + 1 choices.
     *
     * we can take 0,1,2..,n-1-i elements on the right,
     * from A[i] to A[n-1],
     * we have n - i choices.
     *
     * In total, there are k = (i + 1) * (n - i) subarrays, that contains A[i].
     * And there are (k + 1) / 2 subarrays with odd length, that contains A[i].
     * And there are k / 2 subarrays with even length, that contains A[i].
     *
     * A[i] will be counted ((i + 1) * (n - i) + 1) / 2 times for our question.
     */
}
