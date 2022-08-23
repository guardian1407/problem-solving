package com.guardian.problemsolving.scaler.linkedlists;

public class IntersectionOfLinkedLists {
    public static void main(String[] args) {
        ListNode I=new ListNode(6);

        ListNode A=new ListNode(1);
        ListNode T=A;
        T.next=new ListNode(2);
        T=T.next;
        T.next=I;

        ListNode B=new ListNode(3);
        T=B;
        T.next=new ListNode(4);
        T=T.next;
        T.next=new ListNode(5);
        T=T.next;
        T.next=I;

        T=I;
        T.next=new ListNode(7);
        T=T.next;
        T.next=new ListNode(8);
        T=T.next;
        T.next=new ListNode(9);

        ListNode ans=getIntersectionNode(A,B);
        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    public static ListNode getIntersectionNode(ListNode A, ListNode B) {
        //null either A or B
        if(A==null || B==null)return null;
        int l1=getLength(A);
        int l2=getLength(B);
        int diff=Math.abs(l1-l2);

        if(l1>l2)
            A=traverse(A,diff);
        else
            B=traverse(B,diff);

        return getIntersectionNodeHelper(A,B);
    }
    private static int getLength(ListNode A){
        int count=0;
        ListNode curr=A;

        while(curr!=null){
            count++;
            curr=curr.next;
        }
        return count;
    }
    private static ListNode traverse(ListNode A, int steps){
        while(A!=null && steps>0){
            A=A.next;
            steps--;
        }
        return A;
    }
    private static ListNode getIntersectionNodeHelper(ListNode A, ListNode B){
        while(A!=null && B!=null){
            if(A==B)
                return A;
            else{
                A=A.next;
                B=B.next;
            }
        }
        return null;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
