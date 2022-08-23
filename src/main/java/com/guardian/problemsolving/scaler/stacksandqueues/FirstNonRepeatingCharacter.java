package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String A="abadbc";
        System.out.print(solve(A));
    }
    private static String solve(String A) {
        StringBuilder sb=new StringBuilder();
        int[] freq=new int[26];
        Queue<Character> queue=new LinkedList<>();

        for(int i=0;i<A.length();i++){
            int letter=A.charAt(i)-'a';
            freq[letter]++;
            queue.add(A.charAt(i));

            while(!queue.isEmpty() && freq[queue.peek()-'a']>1)
                queue.poll();

            if(queue.isEmpty())
                sb.append("#");
            else
                sb.append(queue.peek());
        }
        return sb.toString();
    }
}
