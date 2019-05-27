package com.epam.javacore2019.Chapter3;

/* 3.4 Напишите класс MyQueue, который реализует очередь с использованием двух стеков.
*P.S. Ужасное задание с извращенским классом, методы которого не выполняются за О(1)*/

public class MyQueue<T extends Comparable> {
    KindaStack<T> mainStack;
    KindaStack<T> subStack;
    boolean removeMode = false;
    int size = 0;

    public MyQueue(KindaStack mainStack, KindaStack subStack) {
        this.mainStack = mainStack;
        this.subStack = subStack;
    }

    public MyQueue() {
        mainStack = new MyStack<>();
        subStack = new MyStack<>();
    }

    public void add(T value) {
        if (!removeMode) {
            mainStack.push(value);
        } else {
            removeMode = false;
            while (subStack.size() != 0) {
                mainStack.push(subStack.pop());
            }
            mainStack.push(value);
        }
        size++;
    }

    public T remove() {
        if (removeMode) {
            size--;
            return subStack.pop();
        } else {
            removeMode = true;
            while (mainStack.size() != 0) {
                subStack.push(mainStack.pop());
            }
            size--;
            return subStack.pop();
        }
    }

    public T peek() {
        T item;
        if (!removeMode) {
            while (mainStack.size() != 0) {
                subStack.push(mainStack.pop());
            }
        }
        item = subStack.pop();
        while (subStack.size() != 0) {
            mainStack.push(subStack.pop());
        }
        mainStack.push(item);
        return item;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }
}
