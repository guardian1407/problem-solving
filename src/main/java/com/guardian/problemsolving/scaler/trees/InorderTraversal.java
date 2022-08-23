package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(6);
        A.right=new TreeNode(2);
        A.right.left=new TreeNode(3);
        inorderTraversal(A).forEach(N->System.out.print(N+" "));
    }
    private static ArrayList<Integer> inorderTraversal(TreeNode A){
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<TreeNode> S=new Stack<>();

        while(A!=null || !S.isEmpty()){
            if(A!=null){
                S.push(A);
                A=A.left;
            }
            else{
                A=S.pop();
                ans.add(A.val);
                A=A.right;
            }
        }
        return ans;
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
}
