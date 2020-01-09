package com.bettercsw.factory.simplefactory;

/**
 * @author csw
 * @date 2019/11/22 16:34
 */
public class TestMain {
    public static void main(String[] args) {
        ICar audi = CarFactory.build("奥迪");
        ICar bmw = CarFactory.build("宝马");
        audi.produce();
        bmw.produce();

        //利用反射
        ICar audi1 = CarFactory.build(Audi.class);
        audi1.produce();
    }


}
