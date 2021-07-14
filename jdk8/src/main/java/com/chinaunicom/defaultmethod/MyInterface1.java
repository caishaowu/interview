package com.chinaunicom.defaultmethod;

/**
 * @author csw
 * @date
 */
public interface MyInterface1 {

    default void defaultMethod() {
        System.out.println("myInterface1");
    }
}
