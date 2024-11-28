package com.bettercsw.decorator;

/**
 * @author csw
 * @date 2020/5/25 11:02
 */
public class Client {
    public static void main(String[] args) {
        //路边摊买个煎饼
        Battercake battercake = new BaseBattercake();
        //加个鸡蛋
        //再加个火腿
        battercake = new HamDecorator(new EggDecorator(battercake));

        //跟静态代理最大的区别就是职责不同
        //静态代理不一定满足 is-a 的关系
        //静态代理会做功能增强，使同一个职责变得不一样

        //装饰者模式会更多考虑扩展
        System.out.println(battercake.getMsg() + ",总价：" + battercake.getPrice());

        Class parent = Battercake.class;
        Class clazz = BaseBattercake.class;
        //clazz是parent类或者parent的子类
        System.out.println(parent.isAssignableFrom(clazz));


    }
}
