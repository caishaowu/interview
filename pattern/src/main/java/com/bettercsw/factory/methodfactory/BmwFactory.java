package com.bettercsw.factory.methodfactory;

/**
 * @author csw
 * @date 2019/11/22 16:53
 */
public class BmwFactory implements ICarFactory{
    @Override
    public  ICar build() {
        return  new Bmw();
    }
}
