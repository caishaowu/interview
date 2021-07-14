package com.bettercsw.factory.simplefactory;

/**
 * 简单工厂模式
 *
 * @author csw
 * @date 2019/11/22 16:28
 */
public class CarFactory {

    public static ICar build(String name) {
        if ("奥迪".equals(name)) {
            return new Audi();
        } else if ("宝马".equals(name)) {
            return new Bmw();
        } else {
            return null;
        }
    }

    public static ICar build(Class<? extends ICar> clazz) {
        if (clazz != null) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
