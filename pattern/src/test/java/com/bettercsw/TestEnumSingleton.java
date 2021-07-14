package com.bettercsw;

import com.bettercsw.singleton.EnumSingleton;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author csw
 * @date 2019/12/11 10:44
 */
public class TestEnumSingleton {

    @Test
    public void test1() {

        try {
            Class clazz = EnumSingleton.class;
            Constructor c = clazz.getDeclaredConstructor();
            c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {

        try {
            Class clazz = EnumSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            EnumSingleton tom = (EnumSingleton) c.newInstance("Tom", 666);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
