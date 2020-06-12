package com.bettercsw.observer;

/**
 * @author csw
 * @date 2020/5/25 17:09
 */
public class MouseEventCallback {

    public void onClick(Event e) {
        System.out.println("============== 触发鼠标单击事件================" + "\n" + e);
    }
    public void onBlur(Event e) {
        System.out.println("============== 触发鼠标失去焦点事件================ "+ "\n" + e);
    }
}
