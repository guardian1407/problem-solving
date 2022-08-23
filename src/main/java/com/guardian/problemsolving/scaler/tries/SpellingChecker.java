package com.guardian.problemsolving.scaler.tries;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SpellingChecker {
    public static void main(String[] args) {
        String[] A={"hat", "cat", "rat"};
        String[] B={"cat", "ball"};
        Arrays.stream(solve(A,B)).forEach(e->System.out.print(e+" "));
    }
    private static int[] solve(String[] A, String[] B) {
        int[] ans=new int[B.length];
        Trie trie=new Trie();

        IntStream.range(0,A.length).forEach(i->insert(trie,A[i]));
        IntStream.range(0,B.length).forEach(i->ans[i]=isPresent(trie,B[i])?1:0);

        return ans;
    }
    private static void insert(Trie trie,String str){
        for(int i=0;i<str.length();i++){
            int pos=str.charAt(i)-'a';
            if(trie.children[pos]==null)
                trie.children[pos]=new Trie();
            trie=trie.children[pos];
        }
        trie.isEnd=true;
    }
    private static boolean isPresent(Trie trie,String str){
        for(int i=0;i<str.length();i++){
            int pos=str.charAt(i)-'a';
            if(trie.children[pos]==null)
                return false;
            trie=trie.children[pos];
        }
        return trie.isEnd;
    }
    private static class Trie{
        boolean isEnd;
        Trie[] children;

        public Trie() {
            isEnd=false;
            children=new Trie[26];
        }
    }
}
