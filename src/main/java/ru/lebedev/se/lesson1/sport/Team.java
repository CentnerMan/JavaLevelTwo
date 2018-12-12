package ru.lebedev.se.lesson1.sport;

/*
2.	Добавить класс Team, который будет содержать название команды, массив из 4-х участников
(т.е. в конструкторе можно сразу всех участников указывать), метод для вывода информации о членах команды,
прошедших дистанцию, метод вывода информации обо всех членах команды.
 */

public class Team {
    String teamName;
    String[] athlete = new String[4];

    public Team(String teamName, String athlete1, String athlete2,String athlete3,String athlete4) {
        this.teamName = teamName;
        athlete[0] = athlete1;
        athlete[1] = athlete2;
        athlete[2] = athlete3;
        athlete[3] = athlete4;
    }

    public void display() {
        System.out.println("Команда: " + teamName);
        for (int i = 0; i < athlete.length; i++) {
            System.out.println(athlete[i]);
        }
    }
    public void showResults(){

    }
}
