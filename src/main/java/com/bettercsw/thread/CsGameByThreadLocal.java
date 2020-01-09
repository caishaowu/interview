package com.bettercsw.thread;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author csw
 * @date 2019/12/20 9:41
 */
public class CsGameByThreadLocal {
    private static final Integer BULLET_NUMBER = 1500;
    private static final Integer KILLED_ENEMIES = 0;
    private static final Integer LIFE_VALUE = 10;

    //为每个线程生成自己的随机数生成器，避免被多实例使用。
    // 虽然共享该实例是线程安全的，但是有可能竞争同一seed导致性能下降


    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return BULLET_NUMBER;
        }
    };
    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return KILLED_ENEMIES;
        }
    };
    private static final ThreadLocal<Integer> LIFE_VALUE_THREADLOCAL = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return LIFE_VALUE;
        }
    };
    private static class Player extends Thread {
        @Override
        public void run() {
            ThreadLocalRandom random = ThreadLocalRandom.current();

            Integer bullets = BULLET_NUMBER_THREADLOCAL.get() - random.nextInt(BULLET_NUMBER);
            Integer killEnemies = KILLED_ENEMIES_THREADLOCAL.get() + random.nextInt(5);
            Integer lifeValue = LIFE_VALUE_THREADLOCAL.get() - random.nextInt(LIFE_VALUE);
            System.out.println(getName() + " bullets = " + bullets );
            System.out.println(getName() + " killEnemies = " + killEnemies);
            System.out.println(getName() + " lifeValue = " + lifeValue + "\n");

            BULLET_NUMBER_THREADLOCAL.remove();
            KILLED_ENEMIES_THREADLOCAL.remove();
            LIFE_VALUE_THREADLOCAL.remove();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Player().start();

        }
    }
}



