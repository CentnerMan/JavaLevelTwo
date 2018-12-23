package ru.lebedev.se.Marathon.Team;


import static ru.lebedev.se.Marathon.Tools.rnd;

public class Cat extends Animal {
    public Cat(String name) {
        super("Кот", name, rnd(150, 250), rnd(18, 22), 0);
    }
}