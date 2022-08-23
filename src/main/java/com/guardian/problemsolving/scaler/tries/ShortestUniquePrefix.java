package com.guardian.problemsolving.scaler.tries;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        String[] A={"zebra", "dog", "duck", "dove"};
        Arrays.stream(prefix(A)).forEach(e->System.out.print(e+" "));
    }
    private static String[] prefix(String[] A) {
        String[] ans=new String[A.length];
        Trie trie=new Trie();
        IntStream.range(0,A.length).forEach(i->insert(trie,A[i]));
        IntStream.range(0,A.length).forEach(i->ans[i]=getPrefix(trie,A[i]));
        return ans;
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
    private static String getPrefix(Trie trie, String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            int pos=str.charAt(i)-'a';
            sb.append(str.charAt(i));
            if(trie.children[pos].count>1)
                trie=trie.children[pos];
            else
                break;
        }
        return sb.toString();
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
