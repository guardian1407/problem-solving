package com.guardian.problemsolving.scaler.bitmanipulation;

public class CountTotalSetBits {
    public static void main(String[] args){
        int A=17;
        System.out.print(solve(A));
    }
    private static int solve(int A)
    {
        int M = 1000000007;

        A++;

        int powOf2 = 2;

        int cnt = A/2;

        while(powOf2 <= A)
        {
            int totalPairs = A/powOf2;

            cnt +=  (totalPairs/2) * powOf2;

            cnt += (totalPairs%2 == 1) ? (A % powOf2) : 0 ;

            cnt = cnt % M;

            powOf2 = powOf2 << 1;

        }

        return cnt%M;
    }
    private static int solve1(int A){
        int mod=(int)1e9+7;
        int i=0;
        int ans=0;

        while((1<<i)<=A){
            boolean k=false;
            int change=1<<i;

            for(int j=0;j<=A;j++){
                if(k)
                    ans+=1%mod;

                if(change==1){
                    k=!k;
                    change=1<<i;
                }
                else
                    change--;
            }
            i++;
        }
        return ans%mod;
    }
//    private static int countSetBits(int n){
//        int mod=(int)1e9+7;
//        int i = 0;
//
//        // ans store sum of set bits from 0 to n
//        int ans = 0;
//
//        // while n greater than equal to 2^i
//        while ((1 << i) <= n) {
//
//            // This k will get flipped after
//            // 2^i iterations
//            boolean k = false;
//
//            // change is iterator from 2^i to 1
//            int change = 1 << i;
//
//            // This will loop from 0 to n for
//            // every bit position
//            for (int j = 0; j <= n; j++) {
//
//                if (k)
//                    ans += 1%mod;
//
//                if (change == 1) {
//
//                    // When change = 1 flip the bit
//                    k = !k;
//
//                    // again set change to 2^i
//                    change = 1 << i;
//                }
//                else {
//                    change--;
//                }
//            }
//
//            // increment the position
//            i++;
//        }
//
//        return ans%mod;
//    }
}
