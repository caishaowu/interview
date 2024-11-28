package com.bettercsw.thread.exercise;

import java.util.concurrent.TimeUnit;

/**
 * @author csw
 * @date 2022/5/18 10:48
 */
public class VolatileTest {

    static class ShareData {

        volatile int num = 0;

        public void setNum() {
            this.num = 100;
        }

        public int getNum() {
            return num;
        }
    }

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            try {

                TimeUnit.SECONDS.sleep(2);
                shareData.setNum();
                System.out.println("set num = 100");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while (shareData.getNum() != 100) {

        }
        System.out.println("done!");

    }
}
