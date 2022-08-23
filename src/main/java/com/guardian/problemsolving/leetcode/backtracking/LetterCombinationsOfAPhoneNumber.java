package com.guardian.problemsolving.leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        letterCombinations(digits).forEach(System.out::println);
    }
    public static List<String> letterCombinations(String digits) {
        Map<String, List<String>> digitMap = new HashMap<>();
        digitMap.put("2", Arrays.asList("a","b","c"));
        digitMap.put("3", Arrays.asList("d","e","f"));
        digitMap.put("4", Arrays.asList("g","h","i"));
        digitMap.put("5", Arrays.asList("j","k","l"));
        digitMap.put("6", Arrays.asList("m","n","o"));
        digitMap.put("7", Arrays.asList("p","q","r","s"));
        digitMap.put("8", Arrays.asList("t","u","v"));
        digitMap.put("9", Arrays.asList("w","x","y","z"));
        return getLetterCombinations(digits, digitMap);
    }
    private static List<String> getLetterCombinations(String digits, final Map<String, List<String>> digitMap) {
        if(digits.length() == 0)
            return new ArrayList<>();
        List<String> currentLetters = digitMap.get(String.valueOf(digits.charAt(0)));
        List<String> res = getLetterCombinations(digits.substring(1), digitMap).stream()
                .map(val -> {
                    List<String> list = new ArrayList<>();
                    for(String letter : currentLetters){
                        list.add(letter+val);
                    }
                    return list;
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return res.isEmpty() ? currentLetters : res;
    }
}
