package com.bettercsw.singleton;

import com.bettercsw.singleton.util.ExecutorThread;


/**
 * @author csw
 * @date 2019/11/29 15:09
 */
public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExecutorThread());
        Thread thread2 = new Thread(new ExecutorThread());
        thread1.start();
        thread2.start();
        System.out.println("End");
    }
}
