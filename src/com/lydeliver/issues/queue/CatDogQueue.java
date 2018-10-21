package com.lydeliver.issues.queue;

import java.util.LinkedList;

/**
 * @ClassName CatDogQueue
 * @Author jonathan
 * @Date 2018/10/17 5:24 PM
 * @Version 1.0
 * @Description TODO
 */
public class CatDogQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order =0;

    public void enqueue(Animals a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog) {
            dogs.add((Dog)a);
        }else if(a instanceof Cat){
            cats.add((Cat)a);
        }
    }

    public Animals dequeue() {
        if (dogs.size() == 0) {
           return dequeueCat();
        }
        if (cats.size() == 0) {
            return dequeueDog();
        }
        if (dogs.peek().isOlder(cats.peek())) {
            return dequeueDog();
        }
        return dequeueCat();

    }

    public Animals dequeueDog() {
        return dogs.poll();
    }

    public Animals dequeueCat() {
        return cats.poll();
    }
}

abstract class Animals{
    String name;
    int order;

    public Animals(String s) {
        name =s;
    }

    public void setOrder(int i) {
        order =i;
    }

    public boolean isOlder(Animals animals) {
       return this.order>animals.order;
    }
}

class Dog extends Animals{


    public Dog(String s) {
        super(s);
    }
}

class Cat extends Animals{
    public Cat(String s) {
        super(s);
    }
}

