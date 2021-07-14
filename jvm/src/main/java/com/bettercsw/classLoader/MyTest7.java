package com.bettercsw.classLoader;

/**
 * @author csw
 * @date 2020/1/15 17:13
 */
public class MyTest7 {

    public static void main(String[] args) {
        System.out.println(MyChild7.a);
        MyChild7.doSomething();
    }
}

class MyParent7 {
    static int a = 3;

    static {
        System.out.println("i am parent");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class MyChild7 extends MyParent7 {
    static {
        System.out.println("i am child");

    }
}
