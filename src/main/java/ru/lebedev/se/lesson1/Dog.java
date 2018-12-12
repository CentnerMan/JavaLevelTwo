package ru.lebedev.se.lesson1;

import ru.lebedev.se.lesson1.interfaces.Swiming;

public class Dog extends Animal implements Swiming {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Гав");
    }

    @Override
    public void Swim() {
        System.out.println("Собака плавает");
    }
}
