package com.bettercsw.observer;



import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Stack;

/**
 * @author csw
 * @date 2020/5/25 17:11
 */
public class Client {
    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();

        //注册事件
        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, callback);
        mouse.addListener(MouseEventType.BLUR, callback);

        //调用方法
        mouse.click();
        mouse.blur();


    }



}
