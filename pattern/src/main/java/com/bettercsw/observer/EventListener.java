package com.bettercsw.observer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 监听器，是观察者的桥梁
 *
 * @author csw
 * @date 2020/5/25 16:20
 */
public class EventListener {

    //JDK 底层的 Lisenter 通常也是这样设计的
    protected Map<String, Event> events = new HashMap<>();

    //通过事件名称和目标对象来触发事件
    public void addListener(String eventType, Object target) {
        try {
            this.addListener(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addListener(String eventType, Object target, Method callback) {
        //注册事件
        events.put(eventType, new Event(target, callback));
    }

    //触发，只要有动作就触发
    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        //发起回调
        if (event.getCallback() != null) {
            //用反射调用它的回调函数
            try {
                event.getCallback().invoke(event.getTarget(), event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //事件名称触发
    protected void trigger(String trigger) {
        if (!this.events.containsKey(trigger)) {
            return;
        }
        Event event = this.events.get(trigger);
        event.setTrigger(trigger);
        trigger(event);
    }

    //首字母大写
    private String toUpperFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

}
