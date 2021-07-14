package com.bettercsw.observer;

/**
 * @author csw
 * @date 2020/5/25 17:01
 */
public class Mouse extends EventListener {

    public void click() {
        System.out.println("单击");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void blur() {
        System.out.println("失去焦点");
        this.trigger(MouseEventType.BLUR);
    }
}
