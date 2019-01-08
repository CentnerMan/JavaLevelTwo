/*
 * Copyright (c) 2019. Created by Anatoly Lebedev
 */

package ru.lebedev.se.lesson3.game.heroes;

import java.util.Random;

import static ru.lebedev.se.lesson3.game.Tools.rnd;

/*
Класс убийца для создания конкретной реализации героя
*/
public class Assasin extends Hero {

    int cricitalHit;
    Random random = new Random();

    public Assasin(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
        this.cricitalHit = rnd(0, 20);
    }

    public Assasin(){
        this.health = rnd(100, 200);
        this.maxHealth = health;
        this.name = randomName();
        this.damage = rnd(60, 80);
        this.addHeal = 0;
        this.cricitalHit = rnd(0, 20);
    }

    @Override
    public void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (hero != this) {
            // если у герой которого бьют жив, его можно ударить
            if (health < 0) {
                System.out.println("Герой " + name + " погиб и бить не может!\n");
            } else {
                hero.causeDamage(damage + cricitalHit);
            }
            System.out.println(this.name + " нанес урон " + hero.name + "\n");
        }
    }

    @Override
    public String hitStr(Hero hero) {
        if (hero != this) {
            // если у герой которого бьют жив, его можно ударить
            if (health < 0) {
                return ("Герой " + name + " погиб и бить не может!\n");
            } else {
                hero.causeDamage(damage + cricitalHit);
                return (this.name + " нанес урон " + (damage + cricitalHit) + " " + hero.name + "\n");
            }
        }
        return ("\n");
    }

    @Override
    public void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!\n");
    }

    @Override
    public String healingStr(Hero hero) {
        return ("Убийцы не умеют лечить!\n");
    }

    @Override
    public String randomName() {
        String[] part1 = {"Эдвин ван Клиф", "Рексар", "Гулдан", "Гаррош", "Малигос", "Лотхиб", "Смертокрыл", "Нефариан"};
        String[] part2 = {"убийца", "уничтожитель", "ненавистник", "захватчик", "победитель", "пожиратель", "ковырятель"};
        String[] part3 = {"миров", "земель", "идей", "людей", "орков", "троллей", "гоблинов", "драконов", "носов"};
        return (part1[rnd(0, part1.length - 1)] + " " + part2[rnd(0, part2.length - 1)] + " " + part3[rnd(0, part3.length - 1)]);

    }
}