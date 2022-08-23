package com.guardian.problemsolving.scaler.trees;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        A.left=new TreeNode(2);
        A.right=new TreeNode(3);
        A.left.left=new TreeNode(4);
        A.left.right=new TreeNode(5);
        A.right.right=new TreeNode(6);
        System.out.print(solve(A));
    }
    private static int solve(TreeNode A){
        return calculateMaxDiameter(A).maxDiameter;
    }
    private static NodeInfo calculateMaxDiameter(TreeNode A){
        NodeInfo nodeInfo=new NodeInfo();

        if(A==null){
            nodeInfo.maxDepth=0;
            nodeInfo.maxDiameter=0;
        }
        else{
            NodeInfo lst=calculateMaxDiameter(A.left);
            NodeInfo rst=calculateMaxDiameter(A.right);

            nodeInfo.maxDepth=Math.max(lst.maxDepth,rst.maxDepth)+1;
            nodeInfo.maxDiameter=Math.max(Math.max(lst.maxDiameter,rst.maxDiameter),lst.maxDepth+rst.maxDepth);
        }
        return nodeInfo;
    }
    private static class NodeInfo {
        int maxDepth;
        int maxDiameter;
        NodeInfo(){}
        NodeInfo(int maxDepth,int maxDiameter) {
            this.maxDepth=maxDepth;
            this.maxDiameter=maxDiameter;
        }
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

//    private static int maXDiameter=0;
//    private static int solve(TreeNode A){
//        calculateMaxDiameter(A);
//        return maXDiameter;
//    }
//    private static int calculateMaxDiameter(TreeNode A){
//        if(A==null)
//            return 0;
//
//        int lstH=calculateMaxDiameter(A.left);
//        int rstH=calculateMaxDiameter(A.right);
//        maXDiameter=Math.max(maXDiameter,lstH+rstH);
//
//        return Math.max(lstH,rstH)+1;
//    }
}
