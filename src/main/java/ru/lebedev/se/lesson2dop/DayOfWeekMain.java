package ru.lebedev.se.lesson2dop;

/*
Требуется реализовать enum DayOfWeekMain, который будет представлять дни недели.
С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели по заднному текущему дню.

 Возвращает кол-во оставшихся рабочих часов до конца
 недели по заданному текущему дню. Считается, что
 текущий день ещё не начался, и рабочие часы за него
 должны учитываться.

public class DayOfWeekMain {

 public static void main(final String[] args) {
 System.out.println(getWorkingHours(DayOfWeekMain.MONDAY));
 }
 */
public class DayOfWeekMain {
    enum DayOfWeek {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    public static void main(final String[] args) {
        for (DayOfWeek s : DayOfWeek.values()) {
            int hours = getWorkingHours(s);
            if (hours > 0)
                System.out.println("Today is " + s.name() + ", before the weekend " + hours + " hours");
            else System.out.println("The weekend has come. :)");
        }
    }

    public static int rnd(int min, int max) { // случайное целое в диапазоне
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static int getWorkingHours(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {

            case MONDAY:
                return rnd(32, 40); // Рандомайзим количество оставшихся часов
            case TUESDAY:
                return rnd(24, 32);
            case WEDNESDAY:
                return rnd(16, 24);
            case THURSDAY:
                return rnd(8, 16);
            case FRIDAY:
                return rnd(0, 8);
            case SATURDAY:
                return 0;
            case SUNDAY:
                return 0;
        }
        return 0;
    }
}
