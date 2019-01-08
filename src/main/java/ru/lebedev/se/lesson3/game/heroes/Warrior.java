/*
 * Copyright (c) 2019. Created by Anatoly Lebedev
 */

package ru.lebedev.se.lesson3.game.heroes;

import static ru.lebedev.se.lesson3.game.Tools.rnd;

/*
Класс воин для создания конкретной реализации героя
*/
public class Warrior extends Hero {

    public Warrior(int health, String type, int damage, int addHeal) {
        super(health, type, damage, addHeal);
    }

    @Override
    public void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (hero != this) {
            // если герой которого бьют жив, его можно ударить
            if (health < 0) {
                System.out.println("Герой " + name + " погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
            }
            System.out.println(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    public String hitStr(Hero hero) {

        if (hero != this) {
            // если у герой которого бьют жив, его можно ударить
            if (health <= 0) {
                return ("Герой " + name + " погиб и бить не может!\n");
            } else {
                hero.causeDamage(damage);
                return (this.name + " нанес урон " + damage + " " + hero.name + "\n");
            }
        }
        return ("\n");
    }

    @Override
    public void healing(Hero hero) {
        System.out.println("Воины не умеют лечить!");
    }

    @Override
    public String healingStr(Hero hero) {
        return ("Убийцы не умеют лечить!\n");
    }

    public Warrior() {
        this.health = rnd(200, 300);
        this.maxHealth = health;
        this.name = randomName();
        this.damage = rnd(40, 60);
        this.addHeal = 0;
    }

    @Override
    public String randomName() {
        String[] part1 = {"Малфурион", "Тарим", "Тирион", "Алакир", "Тралл", "Джараксус", "Рагнарос", "Громмаш", "Кэрн", "Груул"};
        String[] part2 = {"разрушитель", "собиратель", "защитник", "созидатель", "победитель", "пожиратель"};
        String[] part3 = {"миров", "земель", "идей", "людей", "орков", "троллей", "гоблинов", "драконов"};
        return (part1[rnd(0, part1.length - 1)] + " " + part2[rnd(0, part2.length - 1)] + " " + part3[rnd(0, part3.length - 1)]);
    }
}