package ru.lebedev.se.lesson1;

public class StaticClass {

    private String FIO;

    private class InnerStaticLass {

        private String name;

        public void print() {
            FIO = "Иванов Иван Иванович";
        }
    }
}
