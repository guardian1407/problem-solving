package com.guardian.problemsolving.scaler.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrderTraversalBT {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(3);
        A.left=new TreeNode(9);
        A.right=new TreeNode(20);
        A.right.left=new TreeNode(15);
        A.right.right=new TreeNode(7);

        zigzagLevelOrder(A).forEach(list->{
            list.forEach(node->System.out.print(node+" "));
            System.out.println();
        });
    }
    private static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A){
        ArrayList<ArrayList<Integer>> wrapList=new ArrayList<>();
        if(A==null)
            return wrapList;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(A);
        boolean leftToRight=true;

        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> subList=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                subList.add(node.val);

                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }

            if(!leftToRight)
                Collections.reverse(subList);

            leftToRight=!leftToRight;
            wrapList.add(subList);
        }
        return wrapList;
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
