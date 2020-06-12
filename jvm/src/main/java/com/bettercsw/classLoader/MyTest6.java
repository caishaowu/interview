package com.bettercsw.classLoader;

/**
 * @author csw
 * @date 2020/1/15 16:47
 */
public class MyTest6 {
    static {
        System.out.println("i am MyTest6");
    }

    public static void main(String[] args) {
        System.out.println(MyChild6.b);
    }
}
class MyParent6 {
    static int a = 4;
    static {
        System.out.println("i am parent");
    }
}

class MyChild6 extends MyParent6{
    static int b = 5;
    static {
        System.out.println("i am child");
    }
}
