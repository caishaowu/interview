package com.chinaunicom.functionInterface;

import java.util.function.Predicate;

/**
 * @author csw
 * @date
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = p -> p.length() < 5;
        //boolean test(T t);
        System.out.println(predicate.test("hello"));
    }


}
