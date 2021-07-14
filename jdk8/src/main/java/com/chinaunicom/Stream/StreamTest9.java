package com.chinaunicom.Stream;

import com.chinaunicom.pojo.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author csw
 * @date
 */
public class StreamTest9 {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 23);
        Person person3 = new Person("wangwu", 23);
        Person person4 = new Person("zhangsan", 25);
        List<Person> list = Arrays.asList(person1, person2, person3, person4);
        //根据名字进行分组
//        Map<String, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getUsername));
        //根据年龄进行分组
//        Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));
        //根据名字进行分组并计算人数
//        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Person::getUsername,Collectors.counting()));
        //分区，一区为true，一区为false
        Map<Boolean, List<Person>> map = list.stream().collect(Collectors.partitioningBy(person -> person.getAge() <= 23));
        System.out.println(map);


    }
}
