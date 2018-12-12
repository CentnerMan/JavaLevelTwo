package ru.lebedev.se.lesson1.enums;

public enum Fruits {
    ORANGE ("Апельсин", 3),
    APPLE ("Яблоко", 2),
    BANANA ("Банан", 1),
    CHERRY("Вишня", 0);

    private String rus;
    private int number;

    public String getRus() {
        return rus;
    }

    public int getNumber() {
        return number;
    }

    Fruits(String rus, int number) {
        this.rus = rus;
        this.number = number;
    }}
