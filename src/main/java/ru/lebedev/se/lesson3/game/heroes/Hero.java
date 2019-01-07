package ru.lebedev.se.lesson3.game;

/*
Абстрактный класс родитель для создания героев
*/
abstract class Hero {

    // здоровье героя
    protected int health;
    // имя героя
    protected String name;
    // сколько урона может нанести герой
    protected int damage;
    // сколько здоровья может восстановть герой
    protected int addHeal;

    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    // метод нанесения удара
    abstract void hit(Hero hero);

    // метод лечения
    abstract void healing(Hero hero);

    // метод получения удара
    void causeDamage(int damage) {
        if (health < 0) {
            System.out.println("Герой " + name + " уже мертвый!");
        } else {
            health -= damage;
        }

    }

    public int getHealth() {
        return health;
    }

    // метод для добавления здоровья
    void addHealth(int health) {
        this.health += health;
    }

    void info() {

        System.out.println(name + " " + (health < 0 ? "герой мертвый" : health) + " " + damage);
    }
}


