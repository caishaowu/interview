package com.bettercsw.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author csw
 * @date 2020/9/23 10:30
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "t1");
        t1.start();
        System.out.println(t1.isInterrupted());
        TimeUnit.SECONDS.sleep((long) 0.5);

        t1.interrupt();
        System.out.println(t1.isInterrupted());
        System.out.println(t1.isInterrupted());
    }


}
