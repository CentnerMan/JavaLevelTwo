package ru.lebedev.se.biathlon;

/*
3.	Добавить класс Course (полоса препятствий), в котором будут находиться: массив препятствий,
метод, который будет просить команду пройти всю полосу.
 */
public class Course {

    private Step[] step = new Step[4];

    public Course(int distance1, int distance2, int distance3, int distance4) {
        step[0] = new Step(distance1);
        step[1] = new Step(distance2);
        step[2] = new Step(distance3);
        step[3] = new Step(distance4);
    }

    public void doIt(Team team) {
        for (int i = 0; i < 4; i++) {
            team.result[i] = step[i].runDistance() + step[i].doShoots();
            team.shoots[i] = step[i].shotsToString();
        }
    }

}
