package com.epam.javacore2019.Chapter3;

/* 3.5 Напишите программу сортировки стека, в результате которой наименьший элемент оказывается на вершине стека. Вы можете использовать дополнительный временный стек,
* но элементы не должны копироваться в другие структуры данных (например в массив). Стек должен поддерживать следующие операции: push, pop, peek, isEmpty*/

public class Task5 {
    public static <T extends Comparable<T>> void sort(KindaStack<T> stack) {
        MyStack<T> buffer = new MyStack<>();
        while (stack.size() != 0) {
            T item = stack.pop();
            while (buffer.size() != 0) {
                if (item.compareTo(buffer.peek()) < 0) {
                    stack.push(buffer.pop());
                } else {
                    buffer.push(item);
                    break;
                }
            }
            if (buffer.size() == 0) {
                buffer.push(item);
            }
        }

        while (buffer.size() != 0) {
            stack.push(buffer.pop());
        }
    }
}
