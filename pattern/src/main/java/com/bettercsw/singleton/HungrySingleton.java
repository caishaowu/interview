package com.bettercsw.singleton;

import java.io.Serializable;

/**
 * 典型的饿汉式单例模式
 *
 * @author csw
 * @date 2019/11/29 15:03
 */
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
