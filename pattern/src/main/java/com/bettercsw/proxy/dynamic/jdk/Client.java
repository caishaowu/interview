package com.bettercsw.proxy.dynamic.jdk;

import com.bettercsw.proxy.staticproxy.Person;

/**
 * @author csw
 * @date 2020/5/19 16:45
 */
public class Client {
    public static void main(String[] args) {
        try {
            Person obj =   (Person)new MeiPo().getInstance(new SingleDog());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
