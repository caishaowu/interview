package com.bettercsw.singleton;

import java.io.Serializable;

/**
 * 反序列化破坏单例模式
 *
 * @author csw
 * @date 2019/12/4 14:55
 */
public class SerializableSingleton implements Serializable {

    private final static SerializableSingleton INSTANCE = new SerializableSingleton();

    private SerializableSingleton() {
    }

    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
