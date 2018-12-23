package ru.lebedev.se.Marathon.Obstacle;

import ru.lebedev.se.Marathon.Team.Competitor;

public class Water extends Obstacle {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }

}