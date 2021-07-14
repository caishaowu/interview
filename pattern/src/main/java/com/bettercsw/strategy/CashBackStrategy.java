package com.bettercsw.strategy;

/**
 * @author csw
 * @date 2020/5/21 11:08
 */
public class CashBackStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现优惠券，享受现金返还优惠");
    }
}
