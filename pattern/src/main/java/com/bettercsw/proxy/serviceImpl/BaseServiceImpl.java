package com.bettercsw.proxy.serviceImpl;

import com.bettercsw.proxy.service.BaseService;

/**
 * 接口实现类
 * @author csw
 * @date 2019/11/14 15:07
 */
public class BaseServiceImpl implements BaseService {
    @Override
    public void eat() {
        System.out.println("吃饭饭");
    }

    @Override
    public void wc() {
        System.out.println("拉耙耙");
    }
}
