package com.guardian.problemsolving.scaler.trees;

public class MinDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(2);

        System.out.print(minDepth(A));
    }
    private static int minDepth(TreeNode A){
        if(A==null)
            return 0;
        else if(A.left==null && A.right==null)
            return 1;
        else if(A.left==null)
            return minDepth(A.right)+1;
        else if(A.right==null)
            return minDepth(A.left)+1;
        else
            return Math.min(minDepth(A.left),minDepth(A.right))+1;
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
