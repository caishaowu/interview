package com.bettercsw.proxy.util;

import com.bettercsw.proxy.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 监控对象（代理对象）
 *
 * @author csw
 * @date 2019/11/14 15:28
 */
public class ProxyFactory {
    /**
     * JDK动态代理模式下，代理对象的数据类型应该由被监控行为来描述
     * @param clazz 被监控类
     * @return
     * @throws Exception
     */
    public static BaseService Builder(Class clazz) throws Exception{
        //1.创建被监控实例对象
        BaseService obj =(BaseService)clazz.newInstance();
        //2.创建一个通知对象
        InvocationHandler invocation = new Invocation(obj);
        //3.向JVM申请某个类的监控对象（代理对象）,
        /**
         * @param   loader 被监控对象的类加载器
         * @param   interfaces 被监控对象的实现接口
         * @param   h 通知对象，监控对象发现小明要拉耙耙时，应该有一个通知对象进行通知
         * @return  绑定了主要业务与次要业务的对象
         */
        BaseService $proxy =(BaseService)Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), invocation);
        return $proxy;
    }
}
