package com.chinaunicom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author csw
 * @date
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String username;
    private int age;

    //声明的这两个静态方法实际上不符合类的设计原则，因为这两个方法与Person类没有任何关系，这里为了方便演示，所以这么设计
    public static int comparePersonByAge(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }

    public static int comparePersonByName(Person p1, Person p2) {
        return p1.getUsername().compareToIgnoreCase(p2.getUsername());
    }

    public int comparePersonByAge1(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }

    public int comparePersonByAge2(Person p1) {
        return this.age - p1.getAge();
    }

}
