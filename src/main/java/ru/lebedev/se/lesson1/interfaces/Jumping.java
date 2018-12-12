package ru.lebedev.se.lesson1.interfaces;

public interface Jumping {

    void jump();

    default void info(){
        System.out.println("info() from Swiming");
    }
}
