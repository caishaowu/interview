package com.bettercsw.proxy.util;

import com.bettercsw.proxy.service.BaseService;

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

    private BaseService obj;   //具体被监控对象

    public Invocation(BaseService param){
        this.obj = param;
    }
    /**
     * 在被监控行为将要被执行时，JVM进行拦截，将主要业务与次要业务进行绑定
     * @param proxy 代理对象（监控者）
     * @param method 被监控的方法
     * @param args 被监控方法的实参
     * @return 被拦截方法
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String EAT = "eat";
        Object result;
        String methodName = method.getName();
        if(EAT.equals(methodName)){
            //执行次要业务方法
            wash();
            //执行主要业务方法
            result = method.invoke(this.obj, args);
        }else{
            result = method.invoke(this.obj, args);
        }
        return result;
    }

    private void wash(){
        System.out.println("洗手手");
    }
}
