package com.bettercsw.classLoader;

/**
 * 对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为[Lcom.bettercsw.classLoader.MyParent3 这种形式
 * 对于数组来说，JavaDoc 经构成数据的元素成为Component，实际上是将数组降低一个维度后的类型
 * <p>
 * 助记符：anewarray:表示创建一个引用类型（如类、接口）的数组，并将其引用值压入栈顶
 * 助记符：newarray：表示创建一个指定原始类型（int boolean float double）的数组，并将其引用值压入栈顶
 *
 * @author csw
 * @date 2020/1/14 19:08
 */
public class MyTest3 {
    public static void main(String[] args) {
        //创建类的实例，属于主动使用，会导致类的初始化
        MyParent3 myParent3 = new MyParent3();
        MyParent3[] myParent3s = new MyParent3[1];
        //class [Lcom.bettercsw.classLoader.MyParent3;
        System.out.println(myParent3s.getClass());
        //class java.lang.Object
        System.out.println(myParent3s.getClass().getSuperclass());

        int[] i = new int[1];
        //class [I
        System.out.println(i.getClass());
        //class java.lang.Object
        System.out.println(i.getClass().getSuperclass());
    }
}

class MyParent3 {
    static {
        System.out.println("i am parent");
    }
}
