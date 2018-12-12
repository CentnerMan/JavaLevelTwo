package ru.lebedev.se.lesson1.enums;

import java.text.MessageFormat;


public class EnumTest {

    public static void main(String[] args) {
        ru.lebedev.se.lesson1.enums.Fruits fruit = Fruits.CHERRY;
        System.out.println(fruit);

//        if (fruit == Fruits.BANANA) {
//            System.out.println("Это банан");
//        }
//
//        switch (fruit) {
//            case BANANA:
//                System.out.println("Это банан");
//                break;
//            case APPLE:
//                System.out.println("Это яблоко");
//                break;
//            case CHERRY:
//                System.out.println("Это вишня");
//                break;
//            case ORANGE:
//                System.out.println("Это опельсин");
//                break;
//        }

        for (Fruits fruits : Fruits.values()) {
            String s = MessageFormat.format("Название фрукта {0}, номер {1}", fruits.getRus(), fruits.getNumber());
            System.out.println(s);
        }
    }

}
