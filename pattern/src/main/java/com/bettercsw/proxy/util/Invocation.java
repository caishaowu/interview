package com.bettercsw.proxy.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 通知类：
 * 1）次要业务具体实现
 * 2）主要业务与次要业务的绑定
 *
 * @author csw
 * @date 2019/11/14 15:09
 */
public class Invocation implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
