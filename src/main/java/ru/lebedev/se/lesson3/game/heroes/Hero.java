/*
 * Copyright (c) 2019. Created by Anatoly Lebedev
 */

package ru.lebedev.se.lesson3.game.heroes;

/*
Абстрактный класс родитель для создания героев
*/
public abstract class Hero {

    // текущее здоровье героя
    protected int health;
    protected int maxHealth; // Максимальное здоровье, равно изначальному. Больше добавлять нельзя.
    // имя героя
    protected String name;
    // сколько урона может нанести герой
    protected int damage;
    // сколько здоровья может восстановить герой
    protected int addHeal;

    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.maxHealth = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    // метод нанесения удара
    public abstract void hit(Hero hero);

    // метод нанесения удара
    public abstract String hitStr(Hero hero);

    // метод лечения
    public abstract void healing(Hero hero);

    public abstract String healingStr(Hero hero);

    // метод получения удара
    void causeDamage(int damage) {
        if (health <= 0) {
//            System.out.println("Герой " + name + " уже мертвый!");
            health = 0;
        } else {
            health -= damage;
        }
    }

    String causeDamageStr(int damage) {
        if (health <= 0) {
            health = 0;
            return ("Герой " + name + " уже мертвый!");
        } else {
            if (health > damage) {
                health -= damage;
                return ("Герой " + name + " получил " + damage + " урона.");
            } else {
                health = 0;
                return ("Герой " + name + " получил смертельный урон " + damage);
            }
        }
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    // метод для добавления здоровья
    void addHealth(int health) {

        this.health += health;
        if (this.health > maxHealth) this.health = maxHealth; // Нельзя лечится больше максимума
    }

    public String info() {
        return (name + ": " + (health <= 0 ? "погиб" : "осталось здоровья: " + health) + ", наносимый урон:" + damage + "\n");
    }

}


