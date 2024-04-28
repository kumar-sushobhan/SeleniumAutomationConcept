package com.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reverse2charactersOfString {
    public static void main(String[] args) {
        String text = "abmnxy";
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < text.length(); i = i + 2) {
            String s1 = text.charAt(i) + "" + text.charAt(i + 1); //i=1 =>mn
            stringList.add(s1);
        }
        System.out.println(stringList);
        List<String> reverseList = stringList.stream()
                .map(s -> reverseString(s))
                .collect(Collectors.toList());
        System.out.println(reverseList);
    }

    static String reverseString(String s) {
        return Stream.of(s)
                .map(s1 -> new StringBuilder(s1).reverse().toString())
                .collect(Collectors.joining());
    }
}
