package com.guardian.problemsolving.scaler.trees;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(6);
        A.left=new TreeNode(3);
        A.right=new TreeNode(7);
        A.left.left=new TreeNode(2);
        A.left.right=new TreeNode(5);
        A.right.right=new TreeNode(9);

        verticalOrderTraversal(A).forEach(list->{
            list.forEach(node->System.out.print(node+" "));
            System.out.println();
        });
    }
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        if(A!=null){
            Map<Integer,ArrayList<Integer>> levelMap=new HashMap<>();
            Queue<NodeInfo> queue=new LinkedList<>();
            queue.offer(new NodeInfo(A,0));
            int minLevel=0;
            int maxLevel=0;

            while(!queue.isEmpty()){
                NodeInfo nodeInfo=queue.poll();
                TreeNode node=nodeInfo.node;
                int level=nodeInfo.level;
                int val=node.val;
                minLevel=Math.min(minLevel,level);
                maxLevel=Math.max(maxLevel,level);

                ArrayList<Integer> list=!levelMap.containsKey(level) ? new ArrayList<>() : levelMap.get(level);
                list.add(val);
                levelMap.put(level,list);

                if(node.left!=null)
                    queue.offer(new NodeInfo(node.left,level-1));
                if(node.right!=null)
                    queue.offer(new NodeInfo(node.right,level+1));
            }

            for(int i=minLevel;i<=maxLevel;i++)
                ans.add(levelMap.get(i));
        }
        return ans;
    }
    private static class NodeInfo{
        TreeNode node;
        int level;

        public NodeInfo(TreeNode node, int level) {
            this.node = node;
            this.level = level;
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
