package com.bettercsw.thread.exercise;

import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 多线程输出 abcabcabcabcabc
 *
 * @author csw
 * @date 2020/9/24 9:40
 */
@NoArgsConstructor
public class SequencePrint {


    private int flag;
    private int loopNumber;

    public SequencePrint(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) throws InterruptedException {
        SequencePrint sequencePrint = new SequencePrint(1, 5);

        System.out.println("wait+notify version:");
        new Thread(() -> {

            sequencePrint.print("a", 1, 2);
        }).start();
        new Thread(() -> {
            sequencePrint.print("b", 2, 3);
        }).start();
        new Thread(() -> {
            sequencePrint.print("c", 3, 1);
        }).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println();
        System.out.println("park+unpark version:");
        t1 = new Thread(() -> {
            sequencePrint.print2("a", t2);
        });
        t2 = new Thread(() -> {
            sequencePrint.print2("b", t3);
        });
        t3 = new Thread(() -> {
            sequencePrint.print2("c", t1);
        });
        t1.start();
        t2.start();
        t3.start();
        LockSupport.unpark(t1);


    }

    /**
     * wait notify
     *
     * @param str
     * @param currFlag
     * @param nextFlag
     */
    public void print(String str, int currFlag, int nextFlag) {

        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (flag != currFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    /**
     * park unpark
     *
     * @param str
     * @param thread
     */
    public void print2(String str, Thread thread) {

        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.print(str);
            LockSupport.unpark(thread);
        }
    }

}
