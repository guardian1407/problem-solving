package com.guardian.problemsolving.scaler.trees;

import java.util.Stack;

public class CommonNodesInTwoBST {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(7);
        A.left=new TreeNode(1);
        A.right=new TreeNode(10);
        A.left.right=new TreeNode(2);
        A.right.right=new TreeNode(15);
        A.right.right.left=new TreeNode(11);

        TreeNode B=new TreeNode(7);
        B.left=new TreeNode(1);
        B.right=new TreeNode(10);
        B.left.right=new TreeNode(2);
        B.right.right=new TreeNode(15);
        B.right.right.left=new TreeNode(11);

        System.out.print(solve(A,B));
    }
    private static int solve(TreeNode A, TreeNode B){
        long mod=(long)1e9+7;
        long sum=0;
        BSTIterator iteratorA=new BSTIterator(A);
        BSTIterator iteratorB=new BSTIterator(B);

        while(iteratorA.hasNext() && iteratorB.hasNext()){
            int valA=iteratorA.peek();
            int valB=iteratorB.peek();

            if(valA<valB)
                iteratorA.next();
            else if(valA>valB)
                iteratorB.next();
            else{
                sum+=valA%mod;
                iteratorA.next();
                iteratorB.next();
            }
        }

        sum%=mod;
        while(sum<0) {
            sum+=mod;
        }
        sum%=mod;

        return (int)sum;
    }
    private static class BSTIterator {
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack=new Stack<>();
            if(root!=null)
                initialize(root);
        }

        private void initialize(TreeNode node){
            if(node.left==null)
                stack.push(node);
            else{
                stack.push(node);
                initialize(node.left);
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            if(!stack.isEmpty()){
                TreeNode curr=stack.peek();
                findNext();
                return curr.val;
            }
            else
                return -1;
        }

        public int peek() {
            if(!stack.isEmpty())
                return stack.peek().val;
            else
                return -1;
        }

        private void findNext() {
            if(!stack.isEmpty()){
                TreeNode curr=stack.pop();

                if(curr.right!=null)
                    initialize(curr.right);
            }
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
