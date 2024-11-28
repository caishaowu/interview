package com.bettercsw.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author csw
 * @date 2020/9/23 10:29
 */
public class StateTest {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1");

        Thread t2 = new Thread(() -> {
            synchronized (StateTest.class) {
                try {
                    TimeUnit.DAYS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "t2");
        t2.start();

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "t3");
        t3.start();

        Thread t4 = new Thread(() -> {
            synchronized (StateTest.class) {

            }
        }, "t4");

        t4.start();

        Thread t5 = new Thread(() -> {
            while (true) {

            }

        }, "t5");

        t5.start();

        Thread t6 = new Thread(() -> {

        }, "t6");
        t6.start();

        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.out.println(t3.getState());
        System.out.println(t4.getState());
        System.out.println(t5.getState());
        System.out.println(t6.getState());
    }
}
