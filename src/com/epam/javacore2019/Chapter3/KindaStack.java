package com.epam.javacore2019.Chapter3;

import java.util.List;

public interface KindaStack<T> {
    public T pop();
    public void push(T value);
    public int size();
    public T peek();
}
