package com.guardian.problemsolving.test2;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Example1> list = null;
        for (Example1 ex : list){
            System.out.println(ex.example2.str);
        }
    }
    private static void solve(){

    }
    class Example1{
        Example2 example2;
    }
    class Example2{
        String str;
    }
}
