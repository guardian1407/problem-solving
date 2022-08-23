package com.guardian.problemsolving.scaler.linkedlists;

public class KReverseLinkedList {
    public static void main(String[] args) {
        ListNode A=new ListNode(1);
        ListNode T=A;
        T.next=new ListNode(2);
        T=T.next;
        T.next=new ListNode(3);
        T=T.next;
        T.next=new ListNode(4);
        T=T.next;
        T.next=new ListNode(5);
        T=T.next;
        T.next=new ListNode(6);
        int B=3;
        ListNode ans=reverseList(A,B);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode reverseList(ListNode A, int B){
        ListNode l=null;
        ListNode start=A;

        while(start!=null){
            ListNode prev=null;
            ListNode curr=start;
            ListNode next=start.next;

            int i=1;
            while(i<=B){
                curr.next=prev;
                if(i!=B){
                    prev=curr;
                    curr=next;
                    next=next.next;
                }
                i++;
            }

            if(l!=null)
                l.next=curr;
            else
                A=curr;

            start.next=next;
            l=start;
            start=start.next;
        }
        return A;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
