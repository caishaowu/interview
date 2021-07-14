package com.chinaunicom;

/**
 * @author csw
 * @date
 */
@FunctionalInterface
public interface MyInterface {
    static void test3() {
        System.out.println(111);
    }

    void test();

    @Override
    boolean equals(Object obj);

    @Override
    String toString();

    default void test2() {
        System.out.println("hahah...");
    }
}
