package ru.lebedev.se.Marathon.Team;

import java.util.ArrayList;

public class Team {
    public ArrayList<Competitor> team = new ArrayList<Competitor>();


    public Team(ArrayList<Competitor> team) {
        this.team = team;
    }

    public Team(Competitor... competitors) {
        for (Competitor member : competitors) {
            this.team.add(member);
        }
    }

    public void showResults() {
        System.out.println("------------ИТОГОВЫЙ ПРОТОКОЛ------------");
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).isOnDistance())
                System.out.println(team.get(i).getFullName() + " прошел всю дистанцию");
            else System.out.println(team.get(i).getFullName() + " с дистанцией не справился");
        }
        System.out.println("-----------------------------------------");
    }

    public int getTeamSize() {
        return team.size();
    }
}
