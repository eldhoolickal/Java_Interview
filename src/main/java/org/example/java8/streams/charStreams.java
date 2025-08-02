package org.example.java8.streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class charStreams {

    public static void main(String[] args) {

        Predicate<Character> notSpace = c -> c!= ' ';

        //Write program to find char count of string
        String name = "eldho olickal";
        LinkedHashMap<Character, Long> charMap = name.chars()
                        .mapToObj(c -> (char) c)
                        .filter(notSpace)
                        .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
        System.out.println(charMap);
        //output: {e=1, l=3, d=1, h=1, o=2, i=1, c=1, k=1, a=1}

        //find duplicate characters
        List<Character> duplicateCharList = name.chars().mapToObj(c -> (char) c)
                .filter(notSpace)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toUnmodifiableList());
        System.out.println(duplicateCharList);
        //output: [l, o]

        //find non duplicate character
        Set<Character> nonDuplicateCharSet = name.chars().mapToObj(c -> (char) c)
                .filter(notSpace)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(nonDuplicateCharSet);
        //output: [a, c, d, e, h, i, k]

        //Check if two strings are anagrams
        String s1 = "listen";
        String s2 = "silent";

        boolean b = s1.length() == s2.length() && Arrays.equals(s1.chars().sorted().toArray(), s2.chars().sorted().toArray());
        System.out.println(b);
    }
}
