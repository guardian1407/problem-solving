package com.guardian.problemsolving.scaler.linkedlists;

public class AddTwoNumbersAsLists {
    public static void main(String[] args) {
        ListNode A=new ListNode(2);
        ListNode T=A;
        T.next=new ListNode(4);
        T=T.next;
        T.next=new ListNode(3);

        ListNode B=new ListNode(5);
        T=B;
        T.next=new ListNode(6);
        T=T.next;
        T.next=new ListNode(4);

        ListNode ans=addTwoNumbers(A,B);

        while(ans!=null){
            System.out.print(ans.val+"->");
            ans=ans.next;
        }
    }
    private static ListNode addTwoNumbers(ListNode A, ListNode B){
        ListNode ans=null;
        ListNode ansTail=null;
        int carry=0;

        while(A!=null || B!=null || carry==1){
            int valA=A!=null ? A.val : 0;
            int valB=B!=null ? B.val : 0;
            int sum=valA+valB+carry;
            ListNode T=new ListNode(sum%10);
            carry=sum/10;

            if(ans==null){
                ans=T;
                ansTail=T;
            }
            else{
                ansTail.next=T;
                ansTail=ansTail.next;
            }

            if(A!=null)
                A=A.next;
            if(B!=null)
                B=B.next;
        }
        return ans;
    }
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
