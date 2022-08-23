package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPostorder {
    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>(Arrays.asList(6, 1, 3, 2)); //Inorder
        ArrayList<Integer> B= new ArrayList<>(Arrays.asList(6, 3, 2, 1)); //Postorder

        TreeNode root=buildTree(A,B);
        System.out.print(root);
    }
    private static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B){
        Map<Integer,Integer> indexMap=new HashMap<>();

        for(int i=0;i<A.size();i++)
            indexMap.put(A.get(i),i);

        return construct(B,B.size()-1,0,A.size()-1,indexMap).root;
    }
    private static NodeInfo construct(ArrayList<Integer> post, int postIndex, int l, int r, Map<Integer,Integer> indexMap){
        if(l>r)
            return new NodeInfo(null,true,postIndex);

        TreeNode root=new TreeNode(post.get(postIndex--));

        if(!indexMap.containsKey(root.val))
            return new NodeInfo(root,false,postIndex);

        int inIndex=indexMap.get(root.val);
        if(inIndex<l || inIndex>r)
            return new NodeInfo(root,false,postIndex);

        if(l==r)
            return new NodeInfo(root,true,postIndex);

        NodeInfo rst=construct(post,postIndex,inIndex+1,r,indexMap);
        postIndex=rst.index;
        if(!rst.isPossible)
            return new NodeInfo(root,false,postIndex);
        root.right=rst.root;

        NodeInfo lst=construct(post,postIndex,l,inIndex-1,indexMap);
        postIndex=lst.index;
        root.left=lst.isPossible ? lst.root : null;

        return lst.isPossible ? new NodeInfo(root,true,postIndex) : new NodeInfo(root,false,postIndex);
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
