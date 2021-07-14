package com.bettercsw.prototype.shallow;

import lombok.Data;

import java.util.List;

/**
 * 具体需要克隆的类
 *
 * @author csw
 * @date 2020/5/19 14:23
 */
@Data
public class ConcretePrototypeA implements Prototype {
    private Integer age;
    private String name;
    private List hobbies;

    @Override
    public ConcretePrototypeA clone() {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(this.age);
        concretePrototype.setName(this.name);
        concretePrototype.setHobbies(this.hobbies);
        return concretePrototype;
    }
}
