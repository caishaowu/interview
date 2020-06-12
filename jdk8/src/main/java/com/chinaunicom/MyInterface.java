package com.chinaunicom;

/**
 * @author csw
 * @date
 */
public interface MyInterface {
    void test();
    @Override
    boolean equals(Object obj);
    @Override
    String toString();
    default void test2(){
        System.out.println("hahah...");
    }
}
