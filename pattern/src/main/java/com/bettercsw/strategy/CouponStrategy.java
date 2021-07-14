package com.bettercsw.strategy;

/**
 * @author csw
 * @date 2020/5/21 11:07
 */
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减优惠券，享受满减优惠");
    }
}
