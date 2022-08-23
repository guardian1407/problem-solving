package com.guardian.problemsolving.scaler.hashing;

import java.util.HashMap;
import java.util.Map;

public class ChangeDateFormat {
    public static void main(String[] args) {
        String A="1st Mar 1984";
        System.out.print(solve(A));
    }
    private static String solve(String A){
        Map<String,String> dm=new HashMap<>();
        Map<String,String> mm=new HashMap<>();

        dm.put("1st","01");
        dm.put("2nd","02");
        dm.put("3rd","03");
        dm.put("4th","04");
        dm.put("5th","05");
        dm.put("6th","06");
        dm.put("7th","07");
        dm.put("8th","08");
        dm.put("9th","09");
        dm.put("10th","10");
        dm.put("11th","11");
        dm.put("12th","12");
        dm.put("13th","13");
        dm.put("14th","14");
        dm.put("15th","15");
        dm.put("16th","16");
        dm.put("17th","17");
        dm.put("18th","18");
        dm.put("19th","19");
        dm.put("20th","20");
        dm.put("21th","21");
        dm.put("22th","22");
        dm.put("23th","23");
        dm.put("24th","24");
        dm.put("25th","25");
        dm.put("26th","26");
        dm.put("27th","27");
        dm.put("28th","28");
        dm.put("29th","29");
        dm.put("30th","30");
        dm.put("31th","31");

        mm.put("Jan","01");
        mm.put("Feb","02");
        mm.put("Mar","03");
        mm.put("Apr","04");
        mm.put("May","05");
        mm.put("Jun","06");
        mm.put("Jul","07");
        mm.put("Aug","08");
        mm.put("Sep","09");
        mm.put("Oct","10");
        mm.put("Nov","11");
        mm.put("Dec","12");

        String[] date=A.split("\\s+");

        return date[2]+"-"+mm.get(date[1])+"-"+dm.get(date[0]);
    }
}
