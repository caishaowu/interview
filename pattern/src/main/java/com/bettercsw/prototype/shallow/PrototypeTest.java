package com.bettercsw.prototype.shallow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csw
 * @date 2020/5/19 14:29
 */
public class PrototypeTest {
    public static void main(String[] args) {
        //创建一个具体的需要克隆的对象
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        //填充属性，方便测试
        concretePrototype.setAge(18);
        concretePrototype.setName("蔡少武");
        List hobbies = new ArrayList<String>();
        hobbies.add("篮球");
        concretePrototype.setHobbies(hobbies);
        System.out.println(concretePrototype);

        //创建 Clinet 对象，准备开始克隆
        Client client = new Client(concretePrototype);
        ConcretePrototypeA concretePrototypeClone = (ConcretePrototypeA) client.startClone();
        System.out.println(concretePrototypeClone);
        System.out.println("克隆对象中的引用类型地址值：" + concretePrototypeClone.getHobbies());
        System.out.println("原对象中的引用类型地址值：" + concretePrototype.getHobbies());
        System.out.println("对象地址比较：" + (concretePrototypeClone.getHobbies() ==  concretePrototype.getHobbies()));

    }
}
