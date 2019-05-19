package com.epam.javacore2019.Chapter1;

/*Напишите функцию, которая проверяет, является ли заданная строка перестановкой палиндрома.*/

public class Task4 {

    public static boolean isPermutationOfPalindrome(String input) {

        char[] charArray = input.toLowerCase().replaceAll(" ", "").toCharArray();
        boolean once = false;
        int counter;
        StringBuilder checked = new StringBuilder();

        for (char currentChar : charArray) {

            if (checked.toString().contains(String.valueOf(currentChar))) {
                continue;
            }

            counter = 0;
            for (char c : charArray) {
                if (currentChar == c) {
                    counter++;
                }
            }
            if (counter % 2 != 0) {
                if (once) {
                    return false;
                } else {
                    once = true;
                }
            }

            checked.append(currentChar);
        }

        return true;
    }
}
