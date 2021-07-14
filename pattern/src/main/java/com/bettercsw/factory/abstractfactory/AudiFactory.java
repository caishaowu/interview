package com.bettercsw.factory.abstractfactory;

/**
 * @author csw
 * @date 2019/11/22 17:27
 */
public class AudiFactory implements CarFactory {
    @Override
    public ICarBody produceCarBody() {
        return new AudiBody();
    }

    @Override
    public ICarEngine produceCarEngine() {
        return new AudiEngine();
    }
}
