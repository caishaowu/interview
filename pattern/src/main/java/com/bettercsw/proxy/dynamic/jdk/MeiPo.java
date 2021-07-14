package com.bettercsw.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author csw
 * @date 2020/5/19 16:35
 */
public class MeiPo implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object target;

    public Object getInstance(Object target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();
        /**
         * @param   loader 被监控对象的类加载器
         * @param   interfaces 被监控对象的实现接口
         * @param   h 通知对象，监控对象发现小明要拉耙耙时，应该有一个通知对象进行通知
         * @return 绑定了主要业务与次要业务的对象
         */
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    /**
     * 在被监控行为将要被执行时，JVM进行拦截，将主要业务与次要业务进行绑定
     *
     * @param proxy  代理对象（监控者）
     * @param method 被监控的方法
     * @param args   被监控方法的实参
     * @return 被拦截方法
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    private void before() {
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色... ...");
    }

    private void after() {
        System.out.println("配对成功，就地结婚");
    }
}
