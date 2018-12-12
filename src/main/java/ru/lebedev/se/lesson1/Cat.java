package ru.lebedev.se.lesson1;

import ru.lebedev.se.lesson1.interfaces.Jumping;
import ru.lebedev.se.lesson1.interfaces.Swiming;

public class Cat extends Animal implements Swiming, Jumping {

    public static int count = 0;

    public Cat(String name) {
        super(name);
        count++;
    }

    @Override
    public void voice() {
        System.out.println("Мяу");
    }

    public void eat(){

    }

    @Override
    public void Swim() {
        System.out.println("Кошки не любят плавать");
    }

    @Override
    public void info() {

    }

    @Override
    public void jump() {

    }
}
