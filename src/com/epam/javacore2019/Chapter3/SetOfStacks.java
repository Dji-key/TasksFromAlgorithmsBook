package com.epam.javacore2019.Chapter3;

/* 3.3 Реализуйте структуру данных SetOfStacks, которая должна состоять из несккольких стеков. Новый стек создаётся, как только предыдущий достигнет порогового значения.
* Методы push и pop должны вести себя так же, как при работе с одним стеком.
* Дополнительно: реализуйте функцию popAt(int index), которая осуществляет операцию pop с заданным внутренним стеком.*/

import java.util.LinkedList;

public class SetOfStacks<T> implements KindaStack<T>{
    private LinkedList<LinkedList<T>> list = new LinkedList<>();
    private int limit;
    private int size = 0;
    private int innerSize;

    private class Node<T> {
        Node<T> next;
        T value;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public SetOfStacks(int limit) {
        this.limit = limit;
        innerSize = limit;
    }

    public SetOfStacks() {
        this.limit = 10;
        innerSize = limit;
    }

    public void push(T value) {
        if (innerSize == limit) {
            list.add(new LinkedList<T>());
            list.getLast().add(value);
            innerSize = 1;
        } else {
            list.getLast().add(value);
            innerSize++;
        }
        size++;
    }

    public T pop() {
        T result = list.getLast().removeLast();
        --innerSize;
        while (innerSize == 0){
            list.removeLast();
            innerSize = list.getLast().size();
        }
        size--;
        return result;
    }

    public T popAt(int index) {
        return list.get(index).removeLast();
    }

    public int size() {
        return size;
    }

    public T peek() {
        return list.getLast().getLast();
    }
}
