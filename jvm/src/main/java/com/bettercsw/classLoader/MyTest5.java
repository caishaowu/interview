package com.bettercsw.classLoader;

/**
 * @author csw
 * @date 2020/1/15 10:30
 */
public class MyTest5 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
        System.out.println(Singleton.counter3);
    }
}

class Singleton {
    public static int counter1;
    public static int counter2 = 0;
    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
        counter3++;
    }

    public static int counter3 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
