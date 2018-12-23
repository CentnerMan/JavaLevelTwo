package ru.lebedev.se.Marathon;

import ru.lebedev.se.Marathon.Obstacle.*;
import ru.lebedev.se.Marathon.Team.*;
/*
То есть в итоге должно быть что-то вроде:
public static void main(String[] args) {
        Course c = new Course(...); // Создаем полосу препятствий
        Team team = new Team(...);  // Создаем команду
        c.doIt(team);               // Просим команду пройти полосу
        team.showResults();         // Показываем результаты
        }
*/

public class Main {
    public static void main(String[] args) {

//        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
//        Obstacle[] course = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};
//        for (Competitor c : competitors) {
//            for (Obstacle o : course) {
//                o.doIt(c);
//                if (!c.isOnDistance()) break;
//            }
//        }
//
//        for (Competitor c : competitors) {
//            c.info();
//        }

        Team team = new Team(new Human("Боб"), new Human("Джон"),new Cat("Барсик"), new Dog("Бобик"));
        Course course = new Course(new Cross(80), new Wall(2), new Water(10), new Cross(120));

        course.doIt(team);
        team.showResults();
    }

}
