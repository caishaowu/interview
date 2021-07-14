package com.bettercsw.factory.abstractfactory;

/**
 * @author csw
 * @date 2019/11/22 17:24
 */
public class AudiEngine implements ICarEngine {
    @Override
    public void produceEngine() {
        System.out.println("生产奥迪引擎");
    }
}
