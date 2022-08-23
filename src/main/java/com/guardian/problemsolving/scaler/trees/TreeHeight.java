package com.guardian.problemsolving.scaler.trees;

public class TreeHeight {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(4);
        A.right=new TreeNode(3);
        A.left.left=new TreeNode(2);
        System.out.print(solve(A));
    }
    private static int solve(TreeNode A){
        if(A==null)
            return 0;

        int lstH=solve(A.left);
        int rstH=solve(A.right);

        return Math.max(lstH,rstH)+1;
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
