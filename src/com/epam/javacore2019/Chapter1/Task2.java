package com.epam.javacore2019.Chapter1;

/* 1.2 Для двух строк напишите метод, определяющий является ли одна строка перестановкой другой*/

import java.util.HashMap;

public class Task2 {
    public static boolean isPermutation(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        HashMap<Character, Integer> firstMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> secondMap = new HashMap<Character, Integer>();

        for (char c : first.toCharArray()) {
            if (firstMap.containsKey(c)) {
                firstMap.put(c, firstMap.get(c) + 1);
            } else {
                firstMap.put(c, 0);
            }
        }

        for (char c : second.toCharArray()) {
            if (secondMap.containsKey(c)) {
                secondMap.put(c, secondMap.get(c) + 1);
            } else {
                secondMap.put(c, 0);
            }
        }

        return firstMap.equals(secondMap);
    }
}
