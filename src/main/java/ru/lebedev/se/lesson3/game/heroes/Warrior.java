/*
 * Copyright (c) 2019. Created by Anatoly Lebedev
 */

package ru.lebedev.se.lesson3.game.heroes;

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
            if (health < 0) {
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
}