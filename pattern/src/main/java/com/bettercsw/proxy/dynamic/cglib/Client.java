package com.bettercsw.proxy.dynamic.cglib;

/**
 * @author csw
 * @date 2020/5/20 16:12
 */
public class Client {
    public static void main(String[] args) {
        try {
            SingleDog obj = (SingleDog) new CglibMeipo().getInstance(SingleDog.class);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
