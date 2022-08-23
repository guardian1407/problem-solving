package com.guardian.problemsolving.scaler.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MAXAndMIN {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(4, 7, 3, 8));
        System.out.print(solve(A));
    }
    private static int solve(ArrayList<Integer> A){
        long mod=(long)1e9+7;
        int N=A.size();
        ArrayList<Integer> NSELeft=new ArrayList<>();
        ArrayList<Integer> NGELeft=new ArrayList<>();

        ArrayList<Integer> NSERight=new ArrayList<>();
        ArrayList<Integer> NGERight=new ArrayList<>();

        Stack<Integer> SE=new Stack<>();
        Stack<Integer> GE=new Stack<>();

        for(int i=0;i<N;i++){
            int E=A.get(i);

            int NSE=-1;
            if(!SE.isEmpty()){
                if(A.get(SE.peek())<E)
                    NSE=SE.peek();
                else{
                    while(!SE.isEmpty() && A.get(SE.peek())>=E)
                        SE.pop();
                    NSE=!SE.isEmpty() ? SE.peek() : -1;
                }
            }
            NSELeft.add(NSE);
            SE.push(i);

            int NGE=-1;
            if(!GE.isEmpty()){
                if(A.get(GE.peek())>E)
                    NGE=GE.peek();
                else{
                    while(!GE.isEmpty() && A.get(GE.peek())<=E)
                        GE.pop();
                    NGE=!GE.isEmpty() ? GE.peek() : -1;
                }
            }
            NGELeft.add(NGE);
            GE.push(i);
        }

        SE=new Stack<>();
        GE=new Stack<>();
        Stack<Integer> SET=new Stack<>();
        Stack<Integer> GET=new Stack<>();

        for(int i=N-1;i>=0;i--){
            int E=A.get(i);

            int NSE=-1;
            if(!SE.isEmpty()){
                if(A.get(SE.peek())<E)
                    NSE=SE.peek();
                else{
                    while(!SE.isEmpty() && A.get(SE.peek())>=E)
                        SE.pop();
                    NSE=!SE.isEmpty() ? SE.peek() : -1;
                }
            }
            SET.push(NSE);
            SE.push(i);

            int NGE=-1;
            if(!GE.isEmpty()){
                if(A.get(GE.peek())>E)
                    NGE=GE.peek();
                else{
                    while(!GE.isEmpty() && A.get(GE.peek())<=E)
                        GE.pop();
                    NGE=!GE.isEmpty() ? GE.peek() : -1;
                }
            }
            GET.push(NGE);
            GE.push(i);
        }

        while(!SET.isEmpty())
            NSERight.add(SET.pop());

        while(!GET.isEmpty())
            NGERight.add(GET.pop());

        long maxSum=0;
        long minSum=0;
        long ans=0;

        for(int i=0;i<N;i++){
            int l=NSELeft.get(i)+1;
            int r=NSERight.get(i)==-1 ? N-1 : NSERight.get(i)-1;
            int s=i-l+1;
            int e=r-i+1;
            minSum+=(A.get(i)%mod*s%mod*e%mod)%mod;

            l=NGELeft.get(i)+1;
            r=NGERight.get(i)==-1 ? N-1 : NGERight.get(i)-1;
            s=i-l+1;
            e=r-i+1;
            maxSum+=(A.get(i)%mod*s%mod*e%mod)%mod;
        }

        ans=(maxSum%mod-minSum%mod)%mod;

        ans%=mod;
        while(ans<0) {
            ans+=mod;
        }
        ans%=mod;

        return (int)ans;
    }
}
