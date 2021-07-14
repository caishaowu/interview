package com.bettercsw.strategy;

/**
 * @author csw
 * @date 2020/5/21 11:09
 */
public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼图购买，成团后享受团购价");
    }
}
