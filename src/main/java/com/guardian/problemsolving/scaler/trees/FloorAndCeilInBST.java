package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.Arrays;

public class FloorAndCeilInBST {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(8);
        A.left=new TreeNode(5);
        A.right=new TreeNode(19);
        A.left.left=new TreeNode(4);
        A.left.right=new TreeNode(7);
        A.right.right=new TreeNode(100);
        ArrayList<Integer> B=new ArrayList<>(Arrays.asList(1,11));

        solve(A,B).forEach(list->{
            list.forEach(node->System.out.print(node+" "));
            System.out.println();
        });
    }
    private static ArrayList<ArrayList<Integer>> solve(TreeNode A, ArrayList<Integer> B){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        for(int i=0;i<B.size();i++){
            int val=B.get(i);
            int floor=getFloor(A,val);
            int ceil=getCeil(A,val);
            ans.add(new ArrayList<>(Arrays.asList(floor,ceil)));
        }
        return ans;
    }
    private static int getFloor(TreeNode node,int val){
        if(node==null)
            return -1;

        int floor;

        if(node.val<val){
            floor=getFloor(node.right,val);
            floor=floor==-1 ? node.val : floor;
        }
        else if(node.val>val)
            floor=getFloor(node.left,val);
        else
            floor=node.val;

        return floor;
    }
    private static int getCeil(TreeNode node,int val){
        if(node==null)
            return -1;

        int ceil;

        if(node.val<val)
            ceil=getCeil(node.right,val);
        else if(node.val>val){
            ceil=getCeil(node.left,val);
            ceil=ceil==-1 ? node.val : ceil;
        }
        else
            ceil=node.val;

        return ceil;
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
