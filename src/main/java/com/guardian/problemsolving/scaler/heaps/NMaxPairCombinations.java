package com.guardian.problemsolving.scaler.heaps;

import java.util.*;

public class NMaxPairCombinations {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> B=new ArrayList<>(Arrays.asList(3, 4));
        solve(A,B).forEach(e->System.out.print(e+" "));
    }
    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B){
        int N=A.size();
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<PairInfo> pQueue=new PriorityQueue<>(Collections.reverseOrder());
        Set<PairInfo> set=new HashSet<>();
        Collections.sort(A);
        Collections.sort(B);
        PairInfo max=new PairInfo(A.get(N-1)+B.get(N-1),N-1,N-1);
        pQueue.offer(max);
        set.add(max);

        for(int i=0;i<N;i++){
            max=pQueue.poll();
            ans.add(max.sum);
            int l=max.l;
            int r=max.r;

            if(l-1>=0 && r>=0 && !set.contains(new PairInfo(A.get(l-1)+B.get(r),l-1,r))){
                PairInfo p1=new PairInfo(A.get(l-1)+B.get(r),l-1,r);
                pQueue.offer(p1);
                set.add(p1);
            }

            if(l>=0 && r-1>=0 && !set.contains(new PairInfo(A.get(l)+B.get(r-1),l,r-1))){
                PairInfo p2=new PairInfo(A.get(l)+B.get(r-1),l,r-1);
                pQueue.offer(p2);
                set.add(p2);
            }
        }
        return ans;
    }
    private static class PairInfo implements Comparable<PairInfo>{
        int sum;
        int l;
        int r;

        public PairInfo(int sum, int l, int r) {
            this.sum = sum;
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(PairInfo o) {
            return Integer.compare(this.sum,o.sum);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PairInfo pairInfo = (PairInfo) o;
            return l == pairInfo.l &&
                    r == pairInfo.r;
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, r);
        }
    }
}
