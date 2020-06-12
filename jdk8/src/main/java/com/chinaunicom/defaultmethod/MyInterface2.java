package com.chinaunicom.defaultmethod;

/**
 * @author csw
 * @date
 */
public interface MyInterface2 {
    default void defaultMethod(){
        System.out.println("myInterface2");
    }
}
