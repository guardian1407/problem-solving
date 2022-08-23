package com.guardian.problemsolving.scaler.linkedlists;

public class SwapListNodesInPairs {
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
        T=T.next;
        T.next=new ListNode(7);
        ListNode ans=swapPairs(A);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode swapPairs(ListNode A){
        ListNode first=A;
        ListNode prev=null;

        while(first!=null && first.next!=null){
            ListNode second=first.next;
            ListNode next=second.next;
            second.next=first;
            first.next=next;

            if(prev!=null)
                prev.next=second;
            else
                A=second;

            prev=first;
            first=next;
        }
        return A;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
