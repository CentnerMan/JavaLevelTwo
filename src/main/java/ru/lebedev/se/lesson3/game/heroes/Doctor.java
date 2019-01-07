/*
 * Copyright (c) 2019. Created by Anatoly Lebedev
 */

package ru.lebedev.se.lesson3.game.heroes;

/*
Класс доктор для создания конкретной реализации героя
*/
public class Doctor extends Hero {

    public Doctor(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
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
}
