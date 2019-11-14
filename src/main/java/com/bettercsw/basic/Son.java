package com.bettercsw.basic;

/**
 * @author csw
 * @date
 */
public class Son extends Father{
    private int i = test();
    private static int j = method();

    static {
        System.out.print("(6)");
    }
    Son() {
        System.out.print("(7)");
    }
    {
        System.out.print("(8)");
    }
    @Override
    public int test() {
        System.out.print("(9)");
        return 1;
    }
    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println();
        Son son1 = new Son();

    }
}
