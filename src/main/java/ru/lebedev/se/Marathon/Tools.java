package ru.lebedev.se.Marathon;

public class Tools {

    public static int rnd(int min, int max) { // случайное целое в диапазоне
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
