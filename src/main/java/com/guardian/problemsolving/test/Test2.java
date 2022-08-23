package com.guardian.problemsolving.test;

import java.util.List;

public class Test2 {
    private static void solve(int A){


    }
    private static void getList(int open,int close,String temp,int A,List<String> res){
        if(temp.length()==2*A){
            res.add(temp);
            return;
        }
        if(open<A){
            String tempOpen=temp+'(';
            getList(open+1,close,tempOpen,A,res);
        }
        if(close<A && close<open){
            String tempClose=temp+')';
            getList(open,close+1,tempClose,A,res);
        }
    }
}
