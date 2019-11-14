package com.bettercsw.proxy;

import com.bettercsw.proxy.service.BaseService;
import com.bettercsw.proxy.serviceImpl.Person;
import com.bettercsw.proxy.util.ProxyFactory;

/**
 * @author csw
 * @date 2019/11/14 15:41
 */
public class TestMain {
    public static void main(String[] args) {
        try {
            //不能直接new Person()，否则无法进行监控，必须通过代理对象来创建
            BaseService person = ProxyFactory.Builder(Person.class);
            person.eat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
