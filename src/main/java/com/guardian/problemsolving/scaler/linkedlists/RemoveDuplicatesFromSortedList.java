package com.guardian.problemsolving.scaler.linkedlists;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode A=new ListNode(1);
        ListNode T=A;
        T.next=new ListNode(1);
        T=T.next;
        T.next=new ListNode(1);
        T=T.next;
        T.next=new ListNode(4);
        T=T.next;
        T.next=new ListNode(4);
        T=T.next;
        T.next=new ListNode(5);
        T=T.next;
        T.next=new ListNode(6);
        T=T.next;
        T.next=new ListNode(6);
        ListNode ans=deleteDuplicates(A);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode deleteDuplicates(ListNode A){
        ListNode first=A;

        while(first!=null && first.next!=null){
            ListNode second=first.next;
            ListNode next=second.next;

            if(first.val==second.val){
                second.next=null;
                first.next=next;
            }
            else
                first=second;
        }
        return A;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
