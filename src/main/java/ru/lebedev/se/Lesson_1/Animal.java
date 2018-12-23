package ru.lebedev.se.Lesson_1;

public class Animal {

    private int a;
    protected int z;

    public Animal(int a) {
        this.a = a;
    }
}

class Cat extends Animal {

    private int y;
    protected int z;

    public Cat(int a,int y) {
        super(a);
        this.y = y;
    }
}

class SuperCat extends Cat {

    public SuperCat(int a, int y) {
        super(a, y);
    }

    public void test() {
        super.z = 10;
    }

}
