package com.guardian.problemsolving.scaler.linkedlists;

//Using recursion kind of like insertion sort ---> TLE
//Need to do some kind of merge sort
public class SortList {
    public static void main(String[] args) {
        ListNode A=new ListNode(3);
        ListNode T=A;
        T.next=new ListNode(4);
        T=T.next;
        T.next=new ListNode(2);
        T=T.next;
        T.next=new ListNode(8);

        ListNode ans=sortList(A);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode sortList(ListNode A){
        if(A==null || A.next==null)
            return A;

        ListNode next=A.next;
        A.next=null;
        ListNode sorted=sortList(next);
        ListNode prev=null;
        next=sorted;

        while(next!=null && next.val<A.val){
            prev=next;
            next=next.next;
        }
        if(prev==null)
            A.next=sorted;
        else{
            prev.next=A;
            A.next=next;
            A=sorted;
        }
        return A;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
