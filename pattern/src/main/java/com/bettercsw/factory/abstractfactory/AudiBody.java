package com.bettercsw.factory.abstractfactory;

/**
 * @author csw
 * @date 2019/11/22 17:23
 */
public class AudiBody implements ICarBody{
    @Override
    public void produceBody() {
        System.out.println("生产奥迪车身");
    }
}
