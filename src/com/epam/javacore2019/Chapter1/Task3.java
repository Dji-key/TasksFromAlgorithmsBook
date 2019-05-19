package com.epam.javacore2019.Chapter1;

/* 1.3 Напишите метод, заменяющий все пробелы в строке символами '%20'. Можете считать, что длина строки позволяет сохранить дополнительные символы, а фактическая длина строки известна заранее*/
//Чёт странное дальнейшее условие, сделаю как понял кароч.

public class Task3 {

    public static String justReplaceAll(String input) {
        return input.trim().replaceAll(" ", "%20");
    }
}
