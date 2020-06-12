package com.bettercsw.proxy.dynamic.case1;

/**
 * 接口实现类
 * @author csw
 * @date 2019/11/14 15:07
 */
public class Person implements BaseService {
    @Override
    public void eat() {
        System.out.println("吃饭饭");
    }

    @Override
    public void wc() {
        System.out.println("拉耙耙");
    }
}
