package com.bettercsw.singleton.util;

import com.bettercsw.singleton.LazySimpleSingleton;

/**
 * @author csw
 * @date 2019/11/29 15:07
 */
public class ExecutorThread implements Runnable{
    @Override
    public void run() {
        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
