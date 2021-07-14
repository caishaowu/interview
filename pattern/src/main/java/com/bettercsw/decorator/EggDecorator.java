package com.bettercsw.decorator;

/**
 * 鸡蛋装饰者类
 *
 * @author csw
 * @date 2020/5/25 10:56
 */
public class EggDecorator extends Battercake {

    private Battercake battercake;

    public EggDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    // @Override
    // protected void doSomething() {
    //
    // }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice() + 2;
    }

    @Override
    protected String getMsg() {
        return this.battercake.getMsg() + "1个鸡蛋";
    }
}
