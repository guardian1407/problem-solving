package com.guardian.problemsolving.scaler.dynamicprogramming;

public class WaysToDecode {
    private static long mod=(long)1e9+7;
    public static void main(String[] args) {
        String A="161";
        System.out.print(numDecodings(A));
    }
    private static int numDecodings(String A) {
        if(A==null || A.length()==0) return 0;
        int n=A.length();
        long[] dp=new long[n+1];
        dp[0]=1;
        dp[1]=A.charAt(0)!='0' ? 1 : 0;

        for (int i=2;i<=n;i++) {
            int first=Integer.parseInt(A.substring(i-1,i));
            int second=Integer.parseInt(A.substring(i-2,i));

            if(first>0)
                dp[i]+=dp[i-1]%mod;

            if(second>=10 && second<=26)
                dp[i]+=dp[i-2]%mod;
        }
        dp[n]%=mod;
        while(dp[n]<0)
            dp[n]+=mod;
        dp[n]%=mod;
        return (int)dp[n];
    }
    //------------------------------------------------------------------------------------------------------------------------------------
//    private static int numDecodings2(String A) {
//        return (int)decode(A,A.length()-1,new long[A.length()]);
//    }
//    private static long decode(String A,int i,long[] dp){
//        if(i==0)
//            return A.charAt(0)=='0' ? 0 : 1;
//        else{
//            int first=Integer.parseInt(A.substring(i,i+1));
//            int second=Integer.parseInt(A.substring(i-1,i+1));
//            if(dp[i]==0){
//                int num=Integer.parseInt(String.valueOf(A.charAt(i-1)))*10+Integer.parseInt(String.valueOf(A.charAt(i)));
//                dp[i]=num<=26 ? (decode(A,i-1,dp)%mod+decode(A,i-2,dp)%mod)%mod : decode(A,i-1,dp)%mod;
//            }
//            dp[i]%=mod;
//            while(dp[i]<0)
//                dp[i]+=mod;
//            dp[i]%=mod;
//            return dp[i];
//        }
//    }
    public int numDecodings2(String s) {
        int n=s.length();
        Integer[] mem=new Integer[n];
        return s.length()==0?0:numDecodings(0,s,mem);
    }
    private int numDecodings(int p, String s, Integer[] mem) {
        int n=s.length();
        if(p==n) return 1;
        if(s.charAt(p)=='0') return 0;
        if(mem[p]!=null) return mem[p];
        int res=numDecodings(p+1,s,mem);
        if(p<n-1&&(s.charAt(p)=='1'||s.charAt(p)=='2'&&s.charAt(p+1)<'7'))
            res+=numDecodings(p+2,s,mem);
        return mem[p]=res;
    }
}
