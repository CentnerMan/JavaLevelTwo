package ru.lebedev.se.lesson1.sport;

/*
3.	Добавить класс Course (полоса препятствий), в котором будут находиться: массив препятствий,
метод, который будет просить команду пройти всю полосу.
 */
public class Course {
    int distance; // биатлон. Дистанция - среднее время 10 минут +- 2
    boolean shoot1; // + 3 выстрела. Промах + 1 минута к результату
    boolean shoot2;
    boolean shoot3;

    public Course() {
    }

    public void doIt(Team team) {
        for (int i = 0; i < 4; i++) {
            team.result[i] = (int) (8 + (Math.random() * 4));
            for (int j = 0; j < 2; j++) {
                if ((Math.random() * 10) <= 2) {
                    team.result[i] = team.result[i] + 1;
                }
            }
        }
    }

}
