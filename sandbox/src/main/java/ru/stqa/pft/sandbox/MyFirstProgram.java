package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        hello("world");
        hello("user");
        hello("Ilya");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        ///////////////////////////////////////////////////////////////////////////////////

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольнка со сторонами " + r.a + " и " + r.b + " = " + r.area());


        Point p1 = new Point(4, 6, 7, 8);
        System.out.println("Две точки на плоски равны " + p1.distance());
    }

    public static void hello(String somebody) {

        System.out.println("Hello, " + somebody + "!");

    }


}



