package com.guardian.problemsolving.scaler.linkedlists;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode A=new ListNode(5);
        ListNode T=A;
        T.next=new ListNode(8);
        T=T.next;
        T.next=new ListNode(20);

        ListNode B=new ListNode(4);
        T=B;
        T.next=new ListNode(11);
        T=T.next;
        T.next=new ListNode(15);

        ListNode ans=mergeTwoLists(A,B);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode mergeTwoLists(ListNode A, ListNode B){
        ListNode ans=null;
        ListNode ansTail=null;

        while(A!=null && B!=null){
            ListNode T;
            if(A.val<=B.val){
                T=new ListNode(A.val);
                A=A.next;
            }
            else{
                T=new ListNode(B.val);
                B=B.next;
            }

            if(ans==null){
                ans=T;
                ansTail=T;
            }
            else{
                ansTail.next=T;
                ansTail=ansTail.next;
            }
        }

        if(A==null && B!=null){
            if(ans==null)
                ans=B;
            else
                ansTail.next=B;
        }
        else if(A!=null){
            if(ans==null)
                ans=A;
            else
                ansTail.next=A;
        }
        return ans;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
