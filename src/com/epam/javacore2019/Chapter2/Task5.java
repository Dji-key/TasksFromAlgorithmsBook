package com.epam.javacore2019.Chapter2;

/* 2.5 Два числа хранятся в виде связных списков, в которых каждый узел представляет один разряд. Все цифры хранятся в обратном порядке, при этом младший разряд
 * хранится в начале списка. Напишите функцию, которая суммирует два числа и возвращает результат в виде связного списка*/

import java.util.Iterator;
import java.util.LinkedList;

public class Task5 {

    public static LinkedList sum(LinkedList<Integer> first, LinkedList<Integer> second) {
        LinkedList<Integer> result = new LinkedList<>();
        Iterator<Integer> fIt = first.iterator();
        Iterator<Integer> sIt = second.iterator();

        int one = 0;
        int sum = 0;
        while (fIt.hasNext()) {

            if (sIt.hasNext()) {
                sum = fIt.next() + sIt.next() + one;
            } else {
                sum = fIt.next() + one;
            }

            if (sum < 10) {
                result.add(sum);
                one = 0;
            } else {
                result.add(sum%10);
                one = 1;
            }
        }

        while (sIt.hasNext()) {
            sum = sIt.next() + one;

            if (sum < 10) {
                result.add(sum);
                one = 0;
            } else {
                result.add(sum%10);
                one = 1;
            }
        }

        if (one == 1) {
            result.add(1);
        }

        return result;
    }
}
