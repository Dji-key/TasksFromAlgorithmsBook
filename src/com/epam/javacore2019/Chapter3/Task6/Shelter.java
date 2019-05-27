package com.epam.javacore2019.Chapter3.Task6;

import java.util.LinkedList;

/* 3.6 В приюте для животных есть только собаки и кошки, а работа осуществляется в порядке очереди. Люди должны каждый раз забирать "самое старое" (по времени пребывания в питомнике)
* животное, но могут выбрать кошку или собаку (животное в любом случае будет самым старым). Нельзя выбрать любое понравившееся животное. Создайте структуру данных,
* которая обеспечивает функционирование этой системы и реализует операции enqueue, dequeueAny, dequeueCat, dequeueDog. Разрешается использование встроенной структуры данных LinkedList.*/

public class Shelter {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();

    public void enqueue(Animal animal) throws Exception{
        if (animal instanceof Cat) {
            cats.add((Cat) animal);
        } else if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else {
            throw new Exception("wtf");
        }
    }

    public Animal dequeueAny() {
        if (cats.size() >= dogs.size()) {
            return cats.removeLast();
        } else {
            return dogs.removeLast();
        }
    }

    public Cat dequeueCat() {
        return cats.removeLast();
    }

    public Dog dequeue() {
        return dogs.removeLast();
    }
}
