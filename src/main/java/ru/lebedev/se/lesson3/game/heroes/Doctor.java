/*
 * Copyright (c) 2019. Created by Anatoly Lebedev
 */

package ru.lebedev.se.lesson3.game.heroes;

import static ru.lebedev.se.lesson3.game.Tools.rnd;

/*
Класс доктор для создания конкретной реализации героя
*/
public class Doctor extends Hero {

    public Doctor(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
    }

    public Doctor() {
        this.health = rnd(120, 180);
        this.maxHealth = health;
        this.name = randomName();
        this.damage = rnd(40, 60);
        this.addHeal = rnd(60, 80);
    }

    @Override
    public void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    public String hitStr(Hero hero) {
        return ("Доктор не может бить!\n");
    }

    @Override
    public void healing(Hero hero) {
        hero.addHealth(addHeal);
    }


    public String healingStr(Hero hero) {

        hero.addHealth(addHeal);
        return (this.name + " вылечил " + hero.getName() + " на " + addHeal + "\n");
    }

    @Override
    public String randomName() {
        String[] part1 = {"Сильвана", "Джайна", "Лиадрин", "Тиранда", "Валира", "Майев", "Алекстраза", "Изера", "Пейлтресс", "Джайна", "Мариэль"};
        String[] part2 = {"расхитительница", "повелительница", "защитница", "собирательница", "владычица"};
        String[] part3 = {"земель", "стихий", "гробниц", "столиц", "миров", "весов", "голосов"};
        return (part1[rnd(0, part1.length - 1)] + " " + part2[rnd(0, part2.length - 1)] + " " + part3[rnd(0, part3.length - 1)]);
    }

    public String logInfo() {
        return (name + ", здоровье: " + maxHealth + ", хил: " + addHeal + "\n");
    }

}
