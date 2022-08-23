package com.guardian.problemsolving.scaler.trees;

import java.util.*;

public class DistanceBetweenNodesOfBST {
    public static void main(String[] args) {
        DeserializeBinaryTree deserializer=new DeserializeBinaryTree();
        TreeNode A=deserializer.build(new ArrayList<>(Arrays.asList(117,72,168,43,94,141,191,22,58,85,98,129,152,179,203,16,29,48,65,79,92,97,107,119,137,146,160,170,189,193,211,6,21,26,39,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)));
        int B=211;
        int C=39;

        System.out.print(solve(A,B,C));
    }
    private static int solve(TreeNode A, int B, int C){
        NodeInfo firstNode=findNode(A,Math.min(B,C),new Stack<>(),0,0);
        NodeInfo secondNode=trackNext(firstNode.nodeStack,Math.max(B,C),0);
        return secondNode.count;
    }
    private static NodeInfo findNode(TreeNode node,int val,Stack<NodeWrapper> nodeStack,int count,int distance){
        if(node==null)
            return new NodeInfo(nodeStack,false,count);

        nodeStack.push(new NodeWrapper(node,distance));

        if(node.val==val)
            return new NodeInfo(nodeStack,true,count);
        else{
            NodeInfo lst=findNode(node.left,val,nodeStack,count,1);

            if(lst.found)
                return new NodeInfo(nodeStack,true,lst.count+1);
            else{
                nodeStack.pop();
                NodeInfo rst=findNode(node.right,val,nodeStack,count,distance+1);
                return rst.found ? new NodeInfo(rst.nodeStack,true,rst.count+1) : rst;
            }
        }
    }
    private static NodeInfo trackNext(Stack<NodeWrapper> nodeStack,int val,int count){
        NodeWrapper nodeWrapper=nodeStack.pop();
        TreeNode node=nodeWrapper.node;
        if(node.val==val)
            return new NodeInfo(nodeStack,true,count);

        NodeInfo rst=findNode(node.right,val,nodeStack,count,nodeWrapper.distance+1);
        if(rst.found)
            return new NodeInfo(nodeStack,true,rst.count+1);
        else
            return trackNext(nodeStack,val,count+nodeWrapper.distance);
    }
    private static class NodeInfo{
        Stack<NodeWrapper> nodeStack;
        boolean found;
        int count;

        public NodeInfo(Stack<NodeWrapper> nodeStack, boolean found, int count) {
            this.nodeStack = nodeStack;
            this.found = found;
            this.count = count;
        }
    }
    private static class NodeWrapper {
        TreeNode node;
        int distance;

        public NodeWrapper(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
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
    private static class DeserializeBinaryTree {
        private TreeNode build(ArrayList<Integer> A){
            TreeNode root=new TreeNode(A.get(0));
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            int l=1;
            int r=2;

            while(!queue.isEmpty()){
                TreeNode node= queue.poll();
                node.left=A.get(l)!=-1 ? new TreeNode(A.get(l)) : null;
                node.right=A.get(r)!=-1 ? new TreeNode(A.get(r)) : null;

                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

                l+=2;
                r+=2;
            }
            return root;
        }
    }
}
