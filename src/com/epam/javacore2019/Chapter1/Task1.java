package com.epam.javacore2019.Chapter1;

/*Реализуйте алгоритм, определяющий, все ли символы в строке всречаются только один раз. А если при этом запрещено использование дополнтельных структур данных?*/

public class Task1 {
    public static boolean checkString (String input) {

        int length = input.length();
        for (int i = 0; i < length; i++) {
            char[] furtherSymbols = input.substring(i + 1).toCharArray();
            for (char c : furtherSymbols) {
                if (input.charAt(i) == c) {
                    return false;
                }
            }
        }

        return true;
    }
}
