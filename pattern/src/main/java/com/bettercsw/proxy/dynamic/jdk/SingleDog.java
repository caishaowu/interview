package com.bettercsw.proxy.dynamic.jdk;

import com.bettercsw.proxy.staticproxy.Person;

/**
 * @author csw
 * @date 2020/5/19 16:44
 */
public class SingleDog implements Person {
    @Override
    public void findLove() {
        System.out.println("有房有车");
        System.out.println("长得帅，身高180cm");
        System.out.println("八块腹肌");
        System.out.println("对我好");
    }



}
