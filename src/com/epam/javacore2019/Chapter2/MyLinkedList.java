package com.epam.javacore2019.Chapter2;

public class MyLinkedList<T extends Comparable<T>> {

    int size = 0;

    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T value, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)) {
                return false;
            } else if (((Node) obj).value.equals(this.value)) {
                return true;
            } else {
                return false;
            }
        }
    }

    Node<T> head;
    Node<T> tail;

    public void add(T object) {
        Node<T> newNode = new Node<>(tail, object, null);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public void add(T object, int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<T> newNode = new Node<>(current, object, current.next);
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    /* 2.1 Напишите код для удаления дубликатов из несортированного связного списка. Как вы будете решать задачу, если использовать временный буфер запрещено?*/
    public void deleteDuplicates() {
        Node<T> base = head;
        while (base != null) {
            Node<T> current = base.next;
            while (current != null) {
                if (current.equals(base)) {
                    remove(current);
                }
                current = current.next;
            }
            base = base.next;
        }
    }

    /* 2.2 Реализуйте алгоритм для нахождения в односвязном списке k-го элемента с конца.*/
    public T getFromTail(int k) {
        Node<T> current = tail;
        int index = size - k;
        for (int i = 0; i < index + 1; i++) {
            current = current.next;
        }
        return current.value;
    }

    /* 2.3 Реализуйте алгоритм удаляющий узел из середины односвязного списка (Для практики сделал двусвязный список)*/
    public void remove(Node node) {
        if (node == tail) {
            node.prev.next = null;
            tail = node.prev;
            size--;
        } else if (node == head) {
            node.next.prev = null;
            head = node.next;
            size--;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    /* 2.4 Напишите код для разбиения связного списка вокруг значения x, так чтобы все узлы, меньшие x, предшествовали узлам, большим или равным x.
    * Если x содержится в списке, то значения x должны следовать строго после элементов, меньших x. Элемент разбивки x может находиться где угодно в "правой части";
    * он не обязан находиться между левой и правой частью.*/
    public void regroup (T elem) {
        Node<T> current = head.next;
        while (current != null) {
            if (current.value.compareTo(elem) < 0) {
                Node<T> node = current.next;
                remove(current);
                current.next = head;
                head.prev = current;
                current.prev = null;
                head = current;
                current = node;
            }
        }
    }
}
