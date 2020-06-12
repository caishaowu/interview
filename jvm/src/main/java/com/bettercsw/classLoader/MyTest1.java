package com.bettercsw.classLoader;

/**
 *
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时，要求父类全部都已经初始化完毕
 * -XX:+TraceClassLoading 用于追踪类的加载信息并打印出来
 * -XX: +<option> 表示开启option选项
 * -XX: -<option> 表示关闭option选项
 * -XX:<option>=value 表示将option的值设置为value
 *
 * @author csw
 * @date 2020/1/13 15:29
 */
public class MyTest1 {
    public static void main(String[] args) {
        // System.out.println(MyChild1.str2);
        System.out.println("======");
        System.out.println(MyChild1.str);
    }

}
class MyChild1 extends MyParent1{
    public static String str2 = "myChild1";
    static {
        System.out.println("i am child1");
    }

}

class MyParent1 {
    public static String str = "hello world";
    static {
        System.out.println("i am parent1");
    }
}

