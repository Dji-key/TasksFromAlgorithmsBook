package com.epam.javacore2019.Chapter3;

/* 3.2 Как реализовать стек, в котором кроме стандартных функций push и pop будет поддерживаться функция min, возвращающая минимальный элемент?
 * Все операции - push, pop и min - должны выполняться за время О(1).
 * P.S. Как я понимаю, min должна только "показывать" элемент, не убирая его из очереди, а иначе это невозможно сделать за О(1).*/

public class MyStack<T extends Comparable<T>> implements KindaStack<T> {

    private Node<T> current;
    private Node<T> currentMin;
    private int size = 0;

    private class Node<T> {

        Node<T> next;
        T value;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {
        if (current != null) {
            current = new Node<>(value, current);
            if (value.compareTo(currentMin.value) < 0) {
                currentMin = new Node<>(value, currentMin);
            } else {
                currentMin = new Node<>(currentMin.value, currentMin);
            }
        } else {
            current = new Node<>(value, null);
            currentMin = new Node<>(value, null);
        }
        size++;
    }

    public T pop() {
        T result = current.value;
        current = current.next;
        currentMin = currentMin.next;
        size--;
        return result;
    }

    public T min() {
        return currentMin.value;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return current.value;
    }
}
