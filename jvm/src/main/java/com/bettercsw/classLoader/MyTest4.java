package com.bettercsw.classLoader;

import java.util.Random;

/**
 *
 *   当一个接口在初始化时，并不要求其父类接口都完成初始化
 *   只有在真正使用父类接口的时候（如调用父类接口的常量 ），才会进行初始化
 * @author csw
 * @date 2020/1/15 10:01
 */
public class MyTest4 {
    public static void main(String[] args) {
         // System.out.println(MyChild4.b);
         // System.out.println(MyChild4.a);
         System.out.println(MyChild4.thread);
        // System.out.println(MyChild4.c);
    }
}

interface MyParent4 {

    int a = 5;

    Thread thread = new Thread(){
        {
            System.out.println("parent4 invoked");
        }
    };
    //若有初始化，则会报错
    //int i = 1/0;
}

interface MyChild4 extends MyParent4 {
    int b = 6;
    int c = new Random().nextInt(3);
    //若有初始化，则会报错
      int i = 1/0;

}