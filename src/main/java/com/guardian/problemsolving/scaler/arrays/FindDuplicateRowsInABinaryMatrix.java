package com.guardian.problemsolving.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicateRowsInABinaryMatrix {
    public static void main(String[] args) {
        int[][] A= {{1, 1, 1, 0},{0, 0, 0, 1},{1, 1, 1, 0},{0, 0, 0, 1}};
        Arrays.stream(solve(A)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(int[][] A) {
        List<Integer> ans=new ArrayList<>();
        Trie trie=new Trie();

        for(int i=0;i<A.length;i++){
            if(isDuplicateRow(trie,A[i]))
                ans.add(i+1);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    private static boolean isDuplicateRow(Trie trie,int[] row){
        for(int i=0;i<row.length;i++){
            int e=row[i];
            if(trie.children[e]==null)
                trie.children[e]=new Trie();
            trie=trie.children[e];
        }
        if(trie.isEnd)
            return true;
        else{
            trie.isEnd=true;
            return false;
        }
    }
    private static class Trie{
        boolean isEnd;
        Trie[] children;

        public Trie() {
            isEnd=false;
            children=new Trie[2];
        }
    }
}
