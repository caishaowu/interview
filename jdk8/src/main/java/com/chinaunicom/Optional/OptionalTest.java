package com.chinaunicom.Optional;

import java.util.Optional;

/**
 * @author csw
 * @date
 */
public class OptionalTest {
    public static void main(String[] args) {
        //value-based class
        Optional<String> optional = Optional.ofNullable(null);
        Optional<String> hi = Optional.of("hi");

        //面向对象式，不推荐
//        if(optional.isPresent()){
//            System.out.println(optional.get());
//        }

        //函数式编程，推荐
        hi.ifPresent(str -> System.out.println(str));
        //若optional为空，则输出world
        System.out.println(optional.orElse("world"));
        System.out.println(optional.orElseGet(() -> "nihao"));
    }
}
