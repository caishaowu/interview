package com.chinaunicom.methodreference;

import com.chinaunicom.pojo.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author csw
 * @date
 */
public class MethodReferenceTest {
    public String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    public String getString(String str, Function<String, String> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {
        Person p1 = new Person("zhangsan", 15);
        Person p2 = new Person("lisi", 10);
        Person p3 = new Person("wangwu", 32);
        Person p4 = new Person("zhaoliu", 30);

        List<Person> list = Arrays.asList(p1, p2, p3, p4);
        //类名：：静态方法名
//        list.sort(Person::comparePersonByAge);
//        list.forEach(System.out::println);

        //引用名：：实例方法
//        list.sort(p1::comparePersonByAge1);
//        list.forEach(System.out::println);

        //类名：：实例方法
//        list.sort((item1,item2) -> item1.comparePersonByAge2(item2));
//        list.sort(Person::comparePersonByAge2);
//        list.forEach(System.out::println);

        //类名：：new
        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
//      methodReferenceTest.getString(()->new String());
        methodReferenceTest.getString(String::new);
        methodReferenceTest.getString("hi", String::new);
    }
}
