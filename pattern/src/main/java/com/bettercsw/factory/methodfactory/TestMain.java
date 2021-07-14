package com.bettercsw.factory.methodfactory;

/**
 * 工厂方法
 *
 * @author csw
 * @date 2019/11/22 17:05
 */
public class TestMain {
    public static void main(String[] args) {
        ICarFactory audiFactory = new AudiFactory();
        BmwFactory bmwFactory = new BmwFactory();
        ICar audi = audiFactory.build();
        ICar bmw = bmwFactory.build();
        audi.produce();
        bmw.produce();
    }
}
