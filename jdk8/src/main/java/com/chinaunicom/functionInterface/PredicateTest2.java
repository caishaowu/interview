package com.chinaunicom.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author csw
 * @date
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest2 test2 = new PredicateTest2();
        test2.conditionFilter(list, i -> i % 2 == 0);
        test2.conditionFilter(list, i -> true);

        test2.conditionFilter(list, i -> i > 5, i -> i % 2 == 0);
    }

    private void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer i : list) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    private void conditionFilter(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        for (Integer i : list) {
            if (predicate1.and(predicate2).test(i)) {
                System.out.println(i);
            }
        }
    }
}
