package com.guardian.problemsolving.scaler.twopointers;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] A={5,4,6,7,8,9,1,1,100};
        int[] C={5,1,7};
        int B=8;
        A=solve(C,B);
        for(int i=0; i<A.length; i++)
            System.out.print(A[i]+" ");
    }
    static int[] solve(int[] A, int B) {
        if(A.length==1 && A[0]==B){
            int[] ans=new int[1];
            ans[0]=A[0];
            return ans;
        }
        else if(A.length==1){
            int[] ans=new int[1];
            ans[0]=-1;
            return ans;
        }
        else{
            int l=0;
            int r=1;
            boolean flag=false;
            int[] PSA=new int[A.length];
            PSA[0]=A[0];

            for(int i=1; i<A.length; i++)
                PSA[i]=PSA[i-1]+A[i];

            while(l<A.length && r<A.length){
                int diff = l==0?PSA[r]:PSA[r]-PSA[l-1];
                if(diff==B){
                    flag=true;
                    break;
                }
                else if(l==r || diff<B)
                    r++;
                else
                    l++;
            }

            if(!flag){
                int[] ans=new int[1];
                ans[0]=-1;
                return ans;
            }
            else{
                int[] ans=new int[r-l+1];
                for(int i=l,k=0; i<=r; i++,k++)
                    ans[k]=A[i];
                return ans;
            }
        }
    }
}
