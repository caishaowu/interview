package com.chinaunicom.defaultmethod;

/**
 * @author csw
 * @date
 */
public class DefaultMethodTest extends MyInterface1Impl implements  MyInterface2{

    public static void main(String[] args) {
        DefaultMethodTest test = new DefaultMethodTest();
        test.defaultMethod();
    }
}
