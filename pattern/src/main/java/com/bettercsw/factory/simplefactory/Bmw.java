package com.bettercsw.factory.simplefactory;

/**
 * @author csw
 * @date 2019/11/22 16:24
 */
public class Bmw implements ICar {
    @Override
    public void produce() {
        System.out.println("生产宝马汽车");
    }
}
