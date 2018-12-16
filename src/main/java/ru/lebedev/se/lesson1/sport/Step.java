package ru.lebedev.se.lesson1.sport;

public class Step {
    private int distance; // Дистанция в км - среднее время пробега 1 км - 180 секунд +- 20 (
    private boolean[] shoots = new boolean[3]; // + 3 выстрела. выстрел - 10-30 сек, промах + 30 секунд к результату
    private int stepTime; // Время прохождения этапа  в секундах

    public Step(int distance) {
        this.distance = distance;
    }

    public int runDistance(int distance) {
        return distance * rnd(160, 200);
    }

    public int runDistance() {
        return distance * rnd(160, 200);
    }

    public int doShoots() {
        int timeToShoot = 0; //
        for (int i = 0; i < 2; i++) {
            timeToShoot = rnd(10, 30);
            if ((Math.random() * 10) <= 2) { // 20% промаха
                shoots[i] = false;
                timeToShoot = timeToShoot + 30; // 30 сек штраф
            } else shoots[i] = true;
        }
        return timeToShoot;
    }

    public boolean[] getShoots() {
        return shoots;
    }

    public String shotsToString() {
        String s = "[";
        for (int i = 0; i < shoots.length; i++) {
            if (shoots[i]) s = s + "*]";
            else s = s + "-]";
            if (i < shoots.length - 1) s = s + "[";
        }
        return s;
    }

    public int getStepTime() {
        return stepTime;
    }

    public static int rnd(int min, int max) { // случайное целое в диапазоне
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}

