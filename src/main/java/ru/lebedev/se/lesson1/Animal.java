package ru.lebedev.se.lesson1;

public abstract class Animal {

    public static final String COMMON_NAME = "Animal Name";

    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Это конструктор класса Animal");
    }

    public abstract void voice();
}
