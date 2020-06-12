package com.bettercsw.decorator;

/**
 * 火腿类
 * @author csw
 * @date 2020/5/25 11:01
 */
public class HamDecorator extends Battercake{

    private Battercake battercake;

    public HamDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    // @Override
    // protected void doSomething() {
    //
    // }

    @Override
    protected String getMsg() {
        return this.battercake.getMsg() + "1条火腿";
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice() + 2;
    }
}
