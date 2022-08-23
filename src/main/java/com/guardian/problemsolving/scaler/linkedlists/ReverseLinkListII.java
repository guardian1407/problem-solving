package com.guardian.problemsolving.scaler.linkedlists;

public class ReverseLinkListII {
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
        int B=1;
        int C=6;
        ListNode ans=reverseBetween(A,B,C);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode reverseBetween(ListNode A, int B, int C){
        ListNode l=null;
        ListNode start=A;
        int startIndex=1;

        while(startIndex<B){
            l=start;
            start=start.next;
            startIndex++;
        }

        ListNode prev=null;
        ListNode curr=start;
        ListNode next=start.next;
        int endIndex=startIndex;

        while(endIndex<=C){
            curr.next=prev;
            if(endIndex!=C){
                prev=curr;
                curr=next;
                next=next.next;
            }
            endIndex++;
        }

        if(l!=null)
            l.next=curr;
        else
            A=curr;

        start.next=next;
        return A;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
