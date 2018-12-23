package ru.lebedev.se.Marathon.Team;

import static ru.lebedev.se.Marathon.Tools.rnd;

public class Dog extends Animal {
    public Dog(String name) {
        super("Пес", name, rnd(400, 600), rnd(4, 6), rnd(17, 23));
    }
}