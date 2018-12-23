package ru.lebedev.se.Marathon.Obstacle;


import ru.lebedev.se.Marathon.Team.Competitor;
import ru.lebedev.se.Marathon.Team.Team;

import java.util.ArrayList;

public class Course {
    public ArrayList<Obstacle> course = new ArrayList<Obstacle>();

    public Course(ArrayList<Obstacle> course) {
        this.course = course;
    }

    public Course(Obstacle... obstacles) {
        for (Obstacle member : obstacles) {
            this.course.add(member);
        }
    }

    public void doIt(Competitor competitor) {
        for (int i = 0; i < course.size(); i++)
            course.get(i).doIt(competitor);
    }

    public void doIt(Team team) {
        for (int i = 0; i < course.size(); i++) {
            for (int j = 0; j < team.getTeamSize(); j++) {
                course.get(i).doIt(team.team.get(j));
            }

        }
    }
}
