package com.bettercsw.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author csw
 * @date 2020/5/25 17:42
 */
public class Client {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("Tom");
    }
}
