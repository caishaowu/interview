package com.chinaunicom.lambda;

/**
 * @author csw
 * @date 2019年7月30日09:42:33
 */
public class MyRunnable {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("before jdk1.8");
            }
        });
        thread.start();

        new Thread(() -> System.out.println("after jdk1.8")).start();

    }
}
