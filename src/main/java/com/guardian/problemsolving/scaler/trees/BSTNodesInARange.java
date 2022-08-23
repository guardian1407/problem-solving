package com.guardian.problemsolving.scaler.trees;

public class BSTNodesInARange {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(15);
        A.left=new TreeNode(12);
        A.right=new TreeNode(20);
        A.left.left=new TreeNode(10);
        A.left.right=new TreeNode(14);
        A.right.left=new TreeNode(16);
        A.right.right=new TreeNode(27);
        A.left.left.left=new TreeNode(8);
        int B=12;
        int C=20;

        System.out.print(solve(A,B,C));
    }
    private static int solve(TreeNode A, int B, int C){
        return getCount(A,B,C,0);
    }
    private static int getCount(TreeNode node,int min,int max,int count){
        if(node==null)
            return count;

        if(node.val<min)
            count=getCount(node.right,min,max,count);
        else if(node.val<=max){
            count=getCount(node.left,min,max,count);
            count=getCount(node.right,min,max,count);
            count++;
        }
        else
            count=getCount(node.left,min,max,count);

        return count;
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
