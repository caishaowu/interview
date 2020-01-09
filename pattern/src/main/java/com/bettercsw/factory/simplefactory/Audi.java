package com.bettercsw.factory.simplefactory;

/**
 * @author csw
 * @date 2019/11/22 16:26
 */
public class Audi implements ICar {
    @Override
    public void produce() {
        System.out.println("生产奥迪汽车");
    }
}
