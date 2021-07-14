package com.bettercsw.decorator;

/**
 * 原味煎饼类
 *
 * @author csw
 * @date 2020/5/25 10:52
 */
public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg() {
        return "原味煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
