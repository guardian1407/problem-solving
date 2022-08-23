package com.guardian.problemsolving.scaler.trees;

public class PathSum {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(5);
        A.left=new TreeNode(4);
        A.right=new TreeNode(8);
        A.left.left=new TreeNode(11);
        A.right.left=new TreeNode(13);
        A.right.right=new TreeNode(4);
        A.left.left.left=new TreeNode(7);
        A.left.left.right=new TreeNode(2);
        A.right.right.right=new TreeNode(1);
        int B=22;

        System.out.print(hasPathSum(A,B));
    }
    private static int hasPathSum(TreeNode A, int B){
        return hasPathSumHelper(A,B) ? 1 : 0;
    }
    private static boolean hasPathSumHelper(TreeNode root, int sum){
        if(root == null) return false;

        if(root.left == null && root.right == null) return sum == root.val;

        return hasPathSumHelper(root.left, sum - root.val) || hasPathSumHelper(root.right, sum - root.val);
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
