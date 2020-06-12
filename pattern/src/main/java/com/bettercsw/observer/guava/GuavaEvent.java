package com.bettercsw.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author csw
 * @date 2020/5/25 17:41
 */
public class GuavaEvent {
    @Subscribe
    public void subscribe(String str) {
        //业务逻辑
        System.out.println("执行subscribe方法，传入的参数是：" + str);
    }
}
