package com.bettercsw.factory.abstractfactory;

/**
 * @author csw
 * @date 2019/11/22 17:27
 */
public class TestMain {
    public static void main(String[] args) {
        CarFactory audiFactory = new AudiFactory();
        audiFactory.produceCarBody().produceBody();
        audiFactory.produceCarEngine().produceEngine();
    }
}
