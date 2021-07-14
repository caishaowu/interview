package com.bettercsw.factory.abstractfactory;

/**
 * 抽象工厂是用户的主入口
 * 易于扩展
 *
 * @author csw
 * @date 2019/11/22 17:18
 */
public interface CarFactory {
    ICarBody produceCarBody();

    ICarEngine produceCarEngine();
}
