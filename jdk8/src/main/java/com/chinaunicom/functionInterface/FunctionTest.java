package com.chinaunicom.functionInterface;

import java.util.function.Function;

/**
 * @author csw
 * @date 2019年7月31日14:36:58
 */
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest test= new FunctionTest();
        System.out.println(test.compute(5, value -> value * value));

        System.out.println( test.compute(5,value -> value / 2));
        System.out.println( test.compute(3,value -> value - 3));



        test.div(5);
    }

    public int compute(int a, Function<Integer,Integer> function){
        return function.apply(a);
    }
    public int multi(int a){
        return a * a;
    }
    public int div(int a){
        return a /2;
    }
    public int reduce(int a){
        return a - 3;
    }
}
