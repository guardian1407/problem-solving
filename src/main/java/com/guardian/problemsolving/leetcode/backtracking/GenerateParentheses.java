package com.guardian.problemsolving.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n).forEach(System.out::println);
    }
    private static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, "", 0, 0, n);
        return res;
    }
    private static void generateParenthesis(List<String> list, String str, int open, int close, int n) {
        if(str.length()==2*n){
            list.add(str);
            return;
        }

        if(open<n)
            generateParenthesis(list, str+"(", open+1, close, n);
        if(close<open)
            generateParenthesis(list, str+")", open, close+1, n);
    }
}
