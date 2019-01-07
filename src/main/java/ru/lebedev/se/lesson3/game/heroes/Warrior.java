package ru.lebedev.se.lesson3.game;

/*
Класс воин для создания конкретной реализации героя
*/
class Warrior extends Hero {

    public Warrior(int health, String type, int damage, int addHeal) {
        super(health, type, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
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
    void healing(Hero hero) {
        System.out.println("Воины не умеют лечить!");
    }
}