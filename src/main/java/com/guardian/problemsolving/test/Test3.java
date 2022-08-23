package com.guardian.problemsolving.test;

import java.sql.Timestamp;
import java.util.Date;

public class Test3 {
    public static void main(String[] args) {
        Date d=new Date();
        Timestamp t=new Timestamp(new Date().getTime());
        System.out.println(t.toString());
        int x=(int)Math.floor((-3+2)/2.0);
        System.out.println(x);
    }
}
