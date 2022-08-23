package com.guardian.problemsolving.scaler.bitmanipulation;

public class SubArrayOR {
    public static void main(String[] args) {
        int[] A={7, 8, 9, 10};
        System.out.print(solve(A));
    }
    private static int solve(int[] A){
        long mod=(long)1e9+7;
        int N=A.length;
        int max=A[0];
        long total=(N%mod*(N+1)%mod)%mod/2;
        long sum=0;

        for(int i=1;i<N;i++)
            max=Math.max(max,A[i]);

        int M=(int)(Math.log(max)/Math.log(2)) + 1;
        int[][] B=new int[N][M];

        for(int i=0;i<N;i++){
            int index=M-1;
            int num=A[i];
            while(num!=0){
                B[i][index]=num%2;
                num/=2;
                index--;
            }
        }

        for(int j=0;j<M;j++){
            long count=0;
            long subset=0;

            for(int i=0;i<N;i++){
                if(B[i][j]==0)
                    count++;

                if(B[i][j]==1 || i==N-1){
                    subset+=(count%mod*(count+1)%mod)%mod/2;
                    count=0;
                }
            }
            sum+=((Math.pow(2,M-1-j)%mod)*((total%mod-subset%mod)%mod))%mod;
        }
        sum%=mod;
        while(sum<0) {
            sum+=mod;
        }
        sum%=mod;
        return (int)sum;
    }
}
