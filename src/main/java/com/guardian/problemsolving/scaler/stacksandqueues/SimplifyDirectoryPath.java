package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        String A="/home//foo";
        System.out.println(simplifyPath(A));
    }
    private static String simplifyPath(String A) {
        String[] folders=A.split("/");
        Stack<String> stack=new Stack<>();
        List<String> sequence=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<folders.length;i++){
            if("..".equals(folders[i]) && !stack.isEmpty())
                stack.pop();
            else if(!folders[i].isEmpty() && !".".equals(folders[i]) && !"..".equals(folders[i]))
                stack.push(folders[i]);
        }
        while(!stack.isEmpty())
            sequence.add(stack.pop());
        for(int i=sequence.size()-1;i>=0;i--)
            sb.append("/").append(sequence.get(i));
        if(sequence.isEmpty())
            sb.append("/");
        return sb.toString();
    }
}
