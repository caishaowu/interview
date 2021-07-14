package com.chinaunicom.functionInterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author csw
 * @date
 */
public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperatorTest binaryOperator = new BinaryOperatorTest();
        System.out.println(binaryOperator.compute(1, 2, (a, b) -> a + b));

        System.out.println(binaryOperator.minStr("hello1", "world", (a, b) -> a.length() - b.length()));
        System.out.println(binaryOperator.minStr("hello1", "world", (a, b) -> a.charAt(0) - b.charAt(0)));

    }

    private int compute(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }

    private String minStr(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
