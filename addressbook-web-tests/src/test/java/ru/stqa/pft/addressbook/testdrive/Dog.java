package ru.stqa.pft.addressbook.testdrive;

public class Dog {
    //int size;
    String name;
    // String breed;

    public static void main(String[] args) {
        //создаем объект Dog  И ПОЛУЧАЕМ К НЕМУ ДОСТУП
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Барт";

        //теперь создаем массив типа DOG

        Dog[] myDogs = new Dog[3];
        //и поместим в него несколько элементов
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        //Теперь получаем доступ к объектам DOG с помощью ссылок из массива
        myDogs[0].name = "Форд";
        myDogs[1].name = "Джордж";

        //хммм...какой имея у myDogs[2]?
        System.out.print("Имя последней собаки - ");
        //System.out.println(myDogs[2].name);

        //Теперь переберем все элементы массива и вызовем для каждого метод bark()
        int x = 0;
        while (x < (myDogs.length)) {
            myDogs[x].bark();
            x = x + 1;
        }

    }

    void bark() {
        System.out.println(name + " Сказал гав!");
    }

    public void eat() {
    }

    public void chaseCat() {
    }
}
