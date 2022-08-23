package com.guardian.problemsolving.scaler.linkedlists;

public class PalindromeList {
    public static void main(String[] args) {
        ListNode A=new ListNode(1);
        ListNode T=A;
        T.next=new ListNode(2);
        T=T.next;
        T.next=new ListNode(3);
        T=T.next;
        T.next=new ListNode(2);
        T=T.next;
        T.next=new ListNode(1);

        System.out.print(lPalin(A));
    }
    private static int lPalin(ListNode A){
        ListNode prev=null;
        ListNode curr=A;
        ListNode next=A.next;
        ListNode fast=A;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            next=curr.next;
        }

        ListNode l=prev;
        ListNode r=fast!=null ? curr.next : curr;

        while(l!=null && r!=null){
            if(l.val!=r.val)
                return 0;
            l=l.next;
            r=r.next;
        }
        return l==null && r==null ? 1 : 0;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
