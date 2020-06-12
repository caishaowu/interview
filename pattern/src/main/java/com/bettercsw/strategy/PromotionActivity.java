package com.bettercsw.strategy;

/**
 * 促销活动方案类
 * @author csw
 * @date 2020/5/21 11:10
 */
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }
    public void execute() {
        promotionStrategy.doPromotion();
    }
}
