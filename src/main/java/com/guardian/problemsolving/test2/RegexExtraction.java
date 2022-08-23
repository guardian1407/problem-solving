package com.guardian.problemsolving.test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExtraction {
    public static void main(String[] args) {
        String regex = "([0-9]*\\.?[0-9]+)";
        String exp = "T(java.lang.Math).min(1.083 * #processingFee, 1000.0)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(exp);

        double val1 = matcher.find() ? Double.parseDouble(matcher.group()) : 0;
        double val2 = matcher.find() ? Double.parseDouble(matcher.group()) : 0;
        double val3 = matcher.find() ? Double.parseDouble(matcher.group()) : 0;

        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val3);

        double val4 = 5;
        double val5 = 0.897;
        double val6 = 9.0;

        System.out.println(val4);
        System.out.println(val5);
        System.out.println(val6);

        String rule1 = "T (Math).min(%s * #pf, %s)";
        String rule2 = String.format(rule1, val4, val6);
        System.out.print(rule2);
    }
}
