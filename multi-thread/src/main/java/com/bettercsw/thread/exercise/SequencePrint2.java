package com.bettercsw.thread.exercise;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author csw
 * @date 2020/9/24 10:38
 */
@AllArgsConstructor
public class SequencePrint2 extends ReentrantLock {

    private int loopNumber;

    public static void main(String[] args) {
        SequencePrint2 sequencePrint = new SequencePrint2(5);
        Condition a = sequencePrint.newCondition();
        Condition b = sequencePrint.newCondition();
        Condition c = sequencePrint.newCondition();
        new Thread(() -> {

            sequencePrint.print("a", a, b);
        }).start();
        new Thread(() -> {
            sequencePrint.print("b", b, c);
        }).start();
        new Thread(() -> {
            sequencePrint.print("c", c, a);
        }).start();

        sequencePrint.start(a);
    }

    public void start(Condition condition) {
        try {
            this.lock();
            condition.signal();
        } finally {
            this.unlock();
        }

    }

    public void print(String str, Condition current, Condition next) {
        for (int i = 0; i < loopNumber; i++) {
            try {
                this.lock();
                current.await();
                System.out.print(str);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.unlock();
            }
        }
    }
}
