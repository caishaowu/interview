package com.bettercsw.observer;

import javafx.event.EventHandler;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Method;

/**
 * 监听器的一种包装，标准事件原格式的定义
 * @author csw
 * @date 2020/5/25 16:15
 */
@Data
@ToString
public class Event {

    public Event(Object target,Method callback) {
        this.target = target;
        this.callback = callback;
    }
    /**
     * 事件源，事件是由谁发起的，保存起来
     */
    private Object source;
    /**
     * 事件触发，要通知谁
     */
    private Object target;
    /**
     * 事件触发，要做什么动作
     */
    private Method callback;
    /**
     * 事件的名称，触发的是什么事件
     */
    private String trigger;
    /**
     * 事件触发时间
     */
    private long time;
}
