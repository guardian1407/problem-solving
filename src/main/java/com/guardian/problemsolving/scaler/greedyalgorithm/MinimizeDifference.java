package com.guardian.problemsolving.scaler.greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MinimizeDifference {
    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>(Arrays.asList(9, 6, 2, 4, 1, 2, 3, 3));
        int B=10;
        System.out.println(solve(A,B));
    }
    private static int solve(ArrayList<Integer> A, int B) {
        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // find the min and max in the array
        // Also hash the whole array to find the occurrences of all elements
        for (int i=0; i<A.size(); i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
            map.put(A.get(i), map.getOrDefault(A.get(i), 0)+1);
        }
        // terminating condition if B<=0 can't perform any more ops
        while (B>0 && min<max) {
            // if the occurrences of min < if the occurrences of max
            // => increase min by 1
            // else decrease max by 1
            if (map.getOrDefault(min, 0) < map.getOrDefault(max, 0)) {
                // check if the occurrences of min element in array is less than the number of available number ops
                if (B < map.getOrDefault(min, 0))
                    break;
                map.put( min+1, map.getOrDefault(min+1, 0) +
                        map.get(min) );
                B-= map.get(min);
                min = min + 1;


            }
            else {
                //check if the occurrences of max element in array is less than the number of available number ops
                if (B < map.getOrDefault(max, 0))
                    break;
                map.put( max-1, map.getOrDefault(max-1, 0) +
                        map.get(max) );
                B-= map.get(max);
                max = max - 1;
            }
        }

        return max - min;
    }
}
