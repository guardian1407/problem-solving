package com.guardian.problemsolving.scaler.trees;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(15);
        A.left=new TreeNode(12);
        A.right=new TreeNode(20);
        A.left.left=new TreeNode(10);
        A.left.right=new TreeNode(14);

        System.out.print(solve(A));
    }
    private static int solve(TreeNode A){
        if(A==null)
            return 0;

        int lst=solve(A.left);
        int rst=solve(A.right);

        return lst+rst+1;
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
