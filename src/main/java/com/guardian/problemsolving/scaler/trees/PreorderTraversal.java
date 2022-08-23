package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(6);
        A.right=new TreeNode(2);
        A.right.left=new TreeNode(3);
        preorderTraversal(A).forEach(N->System.out.print(N+" "));
    }
    private static ArrayList<Integer> preorderTraversal(TreeNode A){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> rights = new Stack<>();
        while(A != null) {
            list.add(A.val);
            if (A.right != null) {
                rights.push(A.right);
            }
            A = A.left;
            if (A == null && !rights.isEmpty()) {
                A = rights.pop();
            }
        }
        return list;
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
