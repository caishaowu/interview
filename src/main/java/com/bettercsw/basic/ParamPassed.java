package com.bettercsw.basic;

import java.util.Arrays;

/**
 * Java方法的参数传递机制
 *
 * @author csw
 * @date
 */
public class ParamPassed {
    public static void main(String[] args) {
        int i = 200;
        String str = "hello";
        //堆
        Integer num1 = 200;

        //栈
        Integer num2 = 125;
        int[] arr = {1, 2, 3, 4, 5};
        MyData myData = new MyData();
        change(i, str, num1, num2, arr, myData);
        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("myData.a = " + myData.a);

    }

    public static void change(int j, String s, Integer n1, Integer n2, int[] a, MyData m) {
        j += 1;
        s += "world";
        n1 += 1;
        a[0] += 1;
        n2 += 1;
        m.a += 1;
    }
}

class MyData {
    int a = 10;
}
