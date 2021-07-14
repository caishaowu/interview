package com.bettercsw.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author csw
 * @date 2020/10/9 14:36
 */
public class MyAQS extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        if(compareAndSetState(0,1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }



    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}
