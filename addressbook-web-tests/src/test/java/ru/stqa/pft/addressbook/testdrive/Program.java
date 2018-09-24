package ru.stqa.pft.addressbook.testdrive;

public class Program {


    public static void main(String[] args) {

     //   int x = 11;
      //  System.out.println("До цикла " + x);
       // whileCheckIn(3);
       // whileCheckIn(4);
      //  System.out.println("До цикла " + x);
        ifCheckIn(5,4);

    }

    static void whileCheckIn(double x) {
        while (x < 20) {
            x = x + 2;
            System.out.println("внутри цикла, x = " + x);
        }
        do {
            System.out.println("Значение x =" + x);
            x = x + 2;
        } while (x == 20);
        System.out.println("Вне цикла " + x);
    }

    static void ifCheckIn(int x, int z) {
        if (x==5) {
            System.out.println("x = " + x);
        } else {
            System.out.println("А сейчас x = " + x + z);
        }
        System.out.println("Эта строка выполнится в любом случае");
    }


}
