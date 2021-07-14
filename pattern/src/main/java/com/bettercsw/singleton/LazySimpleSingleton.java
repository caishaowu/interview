package com.bettercsw.singleton;

/**
 * 懒汉式单例模式
 *
 * @author csw
 * @date 2019/11/29 15:05
 */
public class LazySimpleSingleton {

    private LazySimpleSingleton() {
    }

    private static LazySimpleSingleton lazy = null;

    public synchronized static LazySimpleSingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
