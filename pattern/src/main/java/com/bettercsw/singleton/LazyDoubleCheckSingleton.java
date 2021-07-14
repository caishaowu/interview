package com.bettercsw.singleton;

/**
 * 双重检查锁单例模式
 *
 * @author csw
 * @date 2019/11/29 15:17
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazy == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazy == null) {
                    //new 初始化对象分为以下3步，volatile 关键字防止指令重排
                    //1.为对象分配内存
                    //2.初始化对象
                    //3.将对象指向刚分配的内存地址
                    lazy = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazy;
    }


}
