package com.bettercsw.thread.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author csw
 * @date 2020/9/23 10:28
 */
@Slf4j
public class GuardedObject {
    public static void main(String[] args) {


        GuardedObject object = new GuardedObject();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                object.complete(null);
                Thread.sleep(1000);
                object.complete("complete");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "t1").start();

        log.info((String) object.get(2100));
    }

    private Object result;

    public Object get(long timeout) {

        synchronized (this) {
            long start = System.currentTimeMillis();
            long passedTime = 0;
            while (result == null) {

                long waitTime = timeout - passedTime;
                log.info("waitTime: {}", waitTime);
                if (waitTime <= 0) {
                    log.info("timeout...");
                    break;
                }
                try {
                    this.wait(waitTime);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - start;

            }
            return result;
        }
    }

    public void complete(Object result) {
        synchronized (this) {
            this.result = result;
            this.notifyAll();
        }
    }
}
