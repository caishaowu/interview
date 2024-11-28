package com.bettercsw.singleton;

import java.lang.reflect.Constructor;

/**
 * 利用反射破坏单例模式
 *
 * @author csw
 * @date 2019/11/29 15:36
 */
public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        Class<?> clazz = LazyInnerClassSingleton.class;
        try {
            //通过反射获取私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            //让类中所有属性可访问，包括 private
            c.setAccessible(true);
            //暴力初始化
            Object o1 = c.newInstance();
            //调用了两次构造方法，产生了两个实例
            Object o2 = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
