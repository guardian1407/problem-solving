package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPreorder {
    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>(Arrays.asList(1, 6, 2, 3)); //Preorder
        ArrayList<Integer> B= new ArrayList<>(Arrays.asList(6, 1, 3, 2)); //Inorder

        System.out.print(buildTree(A,B));
    }
    private static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B){
        Map<Integer,Integer> indexMap=new HashMap<>();

        for(int i=0;i<B.size();i++)
            indexMap.put(B.get(i),i);

        return construct(A,0,0,B.size()-1,indexMap).root;
    }
    private static NodeInfo construct(ArrayList<Integer> pre, int preIndex, int l, int r, Map<Integer,Integer> indexMap){
        if(l>r)
            return new NodeInfo(null,true,preIndex);

        TreeNode root=new TreeNode(pre.get(preIndex++));

        if(!indexMap.containsKey(root.val))
            return new NodeInfo(root,false,preIndex);

        int inIndex=indexMap.get(root.val);
        if(inIndex<l || inIndex>r)
            return new NodeInfo(root,false,preIndex);

        if(l==r)
            return new NodeInfo(root,true,preIndex);

        NodeInfo lst=construct(pre,preIndex,l,inIndex-1,indexMap);
        preIndex=lst.index;
        if(!lst.isPossible)
            return new NodeInfo(root,false,preIndex);
        root.left=lst.root;

        NodeInfo rst=construct(pre,preIndex,inIndex+1,r,indexMap);
        preIndex=rst.index;
        root.right=rst.isPossible ? rst.root : null;

        return rst.isPossible ? new NodeInfo(root,true,preIndex) : new NodeInfo(root,false,preIndex);
    }
    private static class NodeInfo{
        TreeNode root;
        boolean isPossible;
        int index;

        public NodeInfo() {
        }

        public NodeInfo(TreeNode root, boolean isPossible, int index) {
            this.root = root;
            this.isPossible = isPossible;
            this.index = index;
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
}
