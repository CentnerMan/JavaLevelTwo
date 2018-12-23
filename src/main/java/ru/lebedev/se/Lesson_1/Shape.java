package ru.lebedev.se.Lesson_1;

abstract class Shape {
//    public void draw() {
//        System.out.println("draw!");
//    }

    abstract void draw();

    void test() {
        System.out.println("test!");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
       // super.draw();
        //System.out.println("Квадрат");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Круг");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Треугольник!");
    }
}


class MainShape {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Triangle(),
                new Square(),
                new Circle()
        };

        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
        }
    }
}


