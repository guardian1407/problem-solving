package com.guardian.problemsolving.scaler.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ContactFinder {
    public static void main(String[] args) {
        int[] A={0, 0, 1, 1};
        String[] B={"hack", "hacker", "hac", "hak"};
        Arrays.stream(solve(A,B)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(int[] A, String[] B) {
        List<Integer> ans=new ArrayList<>();
        Trie trie=new Trie();
        IntStream.range(0,A.length)
                .forEach(i->{
                    if(A[i]==0)
                        insert(trie,B[i]);
                    else
                        ans.add(getCount(trie,B[i]));
                });
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    private static void insert(Trie trie, String str){
        for(int i=0;i<str.length();i++){
            int pos=str.charAt(i)-'a';
            if(trie.children[pos]==null)
                trie.children[pos]=new Trie(1);
            else
                trie.children[pos].increaseCountBy(1);
            trie=trie.children[pos];
        }
        trie.isEnd=true;
    }
    private static int getCount(Trie trie, String str){
        for(int i=0;i<str.length();i++){
            int pos=str.charAt(i)-'a';
            if(trie.children[pos]!=null)
                trie=trie.children[pos];
            else
                return 0;
        }
        return trie.count;
    }
    private static class Trie{
        int count;
        boolean isEnd;
        Trie[] children;

        public Trie() {
            count=0;
            isEnd=false;
            children=new Trie[26];
        }

        public Trie(int count) {
            this();
            this.count=count;
        }

        public void increaseCountBy(int steps){
            this.count+=steps;
        }
    }
}
