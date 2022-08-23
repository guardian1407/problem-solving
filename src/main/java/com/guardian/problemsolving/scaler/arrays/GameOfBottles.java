package com.guardian.problemsolving.scaler.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameOfBottles {
    public static void main(String[] args) {
        int[] A={1, 2, 3};
        System.out.print(solve(A));
    }
    private static int solve(int[] A) {
        Map<Integer,Integer> hm=new HashMap<>();
        return Arrays.stream(A).map(j -> {
                    if (hm.containsKey(j))
                        hm.put(j, hm.get(j) + 1);
                    else
                        hm.put(j, 1);
                    return hm.get(j);
                })
                .boxed()
                .mapToInt(Integer::intValue)
                .max().orElse(0);
    }
}
