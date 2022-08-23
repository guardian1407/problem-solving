package com.guardian.problemsolving.scaler.trees;

public class SortedArrayToBalancedBST {
    public static void main(String[] args) {
        int[] A={1, 2, 3, 5, 10};
        TreeNode T=sortedArrayToBST(A);
    }
    private static TreeNode sortedArrayToBST(final int[] A){
        return sortedArrayToBST(A,0,A.length-1);
    }
    private static TreeNode sortedArrayToBST(int[] A,int l,int r){
        if(l>r)
            return null;

        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(A[mid]);
        root.left=sortedArrayToBST(A,l,mid-1);
        root.right=sortedArrayToBST(A,mid+1,r);

        return root;
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
