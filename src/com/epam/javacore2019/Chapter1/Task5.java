package com.epam.javacore2019.Chapter1;

/*Напишите функцию, которая проверяет, находятся ли две строки на расстоянии одной модификации (или нуля модификаций)*/

public class Task5 {

    public static boolean isOneMod(String first, String second) {
        int fLength = first.length();
        int sLength = second.length();

        if (StrictMath.abs(fLength - sLength) > 1) {
            return false;
        }

        int min = StrictMath.min(fLength, sLength);

        for (int i = 0; i < min; i++) {

            if (first.charAt(i) == second.charAt(i)) {
                continue;
            }

            if (first.substring(i + 1).equals(second.substring(i + 1))) {
                return true;
            } else if (first.substring(i).equals(second.substring(i + 1))) {
                return true;
            } else if (first.substring(i + 1).equals(second.substring(i))) {
                return true;
            } else {
                return false;
            }
        }

        return true;
    }
}
