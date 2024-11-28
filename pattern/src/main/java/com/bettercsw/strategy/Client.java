package com.bettercsw.strategy;

/**
 * 策略 + 单例 + 工厂
 *
 * @author csw
 * @date 2020/5/21 11:20
 */
public class Client {
    public static void main(String[] args) {

        String promotionKey = "CASHBACK";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();


    }


}
