package ru.lebedev.se.biathlon;

/*
2.	Добавить класс Team, который будет содержать название команды, массив из 4-х участников
(т.е. в конструкторе можно сразу всех участников указывать), метод для вывода информации о членах команды,
прошедших дистанцию, метод вывода информации обо всех членах команды.
 */

public class Team {
    String teamName;
    String[] athlete = new String[4];
    int[] result = new int[4];
    String[] shoots = new String[4];
    public static int teamResult;

    public Team(String teamName, String athlete1, String athlete2, String athlete3, String athlete4) {
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

    public void showResults() {
        System.out.println("Команда: " + teamName);
        for (int i = 0; i < athlete.length; i++) {
            System.out.println("Спортсмен: " + athlete[i] + " результат: " + getTime(result[i]) + ". Отстрелялся: " + shoots[i]);
        }
        for (int i = 0; i < 3; i++) {
            teamResult = teamResult + result[i];
        }
        System.out.println("Итоговый результат: " + getTime(teamResult));
    }

    private String getTime(int s) {
//        int hours = s / 3600;
        int minutes = (s % 3600) / 60;
        int seconds = s % 60;
//        return  hours + "ч " + minutes + "мин " + seconds+ "сек ";
        return minutes + " минут " + seconds + " секунд";
    }
}
