package com.chinaunicom.functionInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author csw
 * @date
 */
public class FunctionTest2 {
    public static void main(String[] args) {
        FunctionTest2 test2 = new FunctionTest2();
        System.out.println(test2.composeTest(2,value -> value * 3, value -> value * value));
        System.out.println(test2.andThenTest(2,value -> value * 3, value -> value * value));
        System.out.println(test2.compute(1,2,(value1,value2) -> value1 + value2));
        System.out.println(test2.biAndThenTest(1,2,(value1,value2) -> value1 + value2,value -> value * value));

    }
    public int composeTest(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.compose(function2).apply(a);
    }
    public int andThenTest(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    /**
     *  实现两个变量的数值操作，具体行为由用户定义
     */
    public int compute(int a, int b, BiFunction<Integer,Integer,Integer> function){
        return function.apply(a,b);
    }
    public int biAndThenTest(int a, int b, BiFunction<Integer,Integer,Integer> biFunction, Function<Integer,Integer> function){
        return biFunction.andThen(function).apply(a,b);
    }
}
