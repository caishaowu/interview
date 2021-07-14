package com.bettercsw.strategy;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
