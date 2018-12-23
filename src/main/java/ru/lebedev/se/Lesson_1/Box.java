package ru.lebedev.se.Lesson_1;

public class Box {

    protected String color;

    int weight;
    String name;
    private int age;

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        } else {
            System.out.println("Возраст не может отрицательным!");
        }
    }

    public Box(String color, int weight, String name) {
        this.color = color;
        this.weight = weight;
        this.name = name;
    }

    public Box(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Box(String color) {
        this.color = color;
    }

    public Box() {

    }


    void info() {
        System.out.println(name + " " + weight + " " + color);
    }


    void startTest(Tools tools) {
        tools.infoToolsAndBox(this);
    }
}

class Tools {

    Box box = new Box();

    String tools;

    public Tools(String tools) {
        this.tools = tools;
    }

    void infoToolsAndBox(Box box) {
        box.color = "sad";
        System.out.println(tools + " " + box.color);
    }
}

class Main {
    public static void main(String[] args) {
        Box box = new Box("red", 10);
        Tools tools = new Tools("Hummer");
        box.startTest(tools);


//        String str = null;
//        System.out.println(str);

//        int i;
//        System.out.println(i);

        //  int i, j, z = 1; i = j + z;

//        Box[] boxs = {new Box(), new Box()};
//
//        boxs[0].name = "box1";
//        boxs[1].weight = 20;
//
//        boxs[0].info();
//        boxs[1].info();

//        Box box1 = new Box("red",10,"Box1");
//        Box box2 = new Box("white",15,"Box2");
//
//        box2 = box1;
//
//        box1.name = "box3";
//        box2.weight = 20;
//
//        box1.info();
//        box2.info();


//        box1.info();

        //   summ("asd",2,4);
        //  summ(2,4);
//        summ(2,4,5,8);
//        Main main = new Main();
//        main.test();

        // test();
    }

    void test() {
        System.out.println(1);
    }

//    static void summ(int... b) {
//        int res = 0;
//        for (int i = 0; i < b.length; i++) {
//            res += b[i];
//        }
//        System.out.println(res);
//    }

//    static void summ(int a, int b) {
//        System.out.println(a + b);
//    }
//
//    static void summ(int a, int b, int z) {
//        System.out.println(a + b + z);
//    }
//
//    static void summ(int a, int b, int z, int y) {
//        System.out.println(a + b + z + y);
//    }

}