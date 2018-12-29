package ru.lebedev.se.lesson3.phonebook;

import java.util.ArrayList;

/*
Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.

Желательно как можно меньше добавлять своего, чего нет в задании
(т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
делать взаимодействие с пользователем через консоль и т.д. Консоль желательно не использовать для ввода,
тестировать просто из метода main(), прописывая add() и get().

 */
public class PhoneBook {
    static ArrayList<Clients> clients = new ArrayList<>();

    public static void main(String[] args) {
        add("Иванов", "223322");
        add("Петров", "463636");
        add("Сидоров", "865433");
        add("Васильев", "564322");
        add("Гусев", "865544");
        add("Иванов", "123456");

        get("Иванов");
        get("Гусев");
        get("Путин");
    }

    public static void add(String name, String phone){
        clients.add(new Clients(name,phone));
    }

    public static void get(String name) {
        for (int i = 0; i < clients.size(); i++) {
            if ((clients.get(i).getName() == name)) {
                System.out.println(clients.get(i).toString());
            }
        }
    }

}
