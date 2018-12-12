package ru.lebedev.se.lesson1.interfaces;

public interface Swiming {

    int lenght = 2090;

    void Swim();

    default void info(){
        System.out.println("info() from Swiming");
    }
}
