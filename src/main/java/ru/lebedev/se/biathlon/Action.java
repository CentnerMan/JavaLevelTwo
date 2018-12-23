package ru.lebedev.se.biathlon;

/*
То есть в итоге должно быть что-то вроде:
public static void main(String[] args) {
    Course c = new Course(...); // Создаем полосу препятствий
    Team team = new Team(...);  // Создаем команду
    c.doIt(team);               // Просим команду пройти полосу
    team.showResults();         // Показываем результаты
}

 */
public class Action {
    public static void main(String[] args) {
        Course c = new Course(3, 5, 3, 5); // Создаем полосу препятствий
        Team team = new Team("Лопушки", "Вася", "Петя", "Дима", "Вова");  // Создаем команду
        c.doIt(team);               // Просим команду пройти полосу
        team.showResults();         // Показываем результаты
    }
}
