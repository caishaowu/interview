package com.bettercsw.classLoader;

import java.util.UUID;

/**
 * 编译时可以确定的常量在编译阶段会存入到调用这个常量所在类（MyTest2）的常量池中
 * 本质上，调用类（MyTest2）并没有直接调用到定义常量的类（MyParent2），因此不会触发定义常量所在类（MyParent2）的初始化
 * 注意：编译时已经将常量存到MyTest2的常量池，之后MyTest2和MyParent2就没有任何关系了
 * 甚至我们可以将MyParent2的class文件删除，程序还可以正常运行
 * <p>
 * <p>
 * 助记符 ldc：表示将int、float或者String类型的常量值从常量池中推送至栈顶
 * 助记符 bipush：表示将单字节（-128-127）的常量值推送至栈顶
 * 助记符 sipush：表示将一个短整型值（-32768-32769）推送至栈顶
 * 助记符 iconst_1：表示将int型的1推送至栈顶（iconst_m1 - iconst5)
 *
 * @author csw
 * @date 2020/1/13 17:24
 */
public class MyTest2 {
    public static void main(String[] args) {
        //hello world
        System.out.println(MyParent2.str);
        System.out.println(MyParent2.s);
        System.out.println(MyParent2.i);
        System.out.println(MyParent2.j);
    }
}

class MyParent2 {
    //public static final String str = "hello world";              //编译时确定
    public static final String str = UUID.randomUUID().toString(); //运行时确定
    public static final short s = 7;
    public static final int i = 129;
    public static final int j = 1;

    static {
        System.out.println("i am MyParent2");
    }
}
