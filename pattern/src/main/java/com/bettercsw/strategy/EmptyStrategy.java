package com.bettercsw.strategy;

/**
 * @author csw
 * @date 2020/5/21 11:19
 */
public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
