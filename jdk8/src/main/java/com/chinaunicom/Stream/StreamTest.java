package com.chinaunicom.Stream;

import com.chinaunicom.pojo.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author csw
 * @date
 */
public class StreamTest {
    public static void main(String[] args) {
        Person p1 = new Person("zhangsan",20);
        Person p2 = new Person("lisi",25);
        Person p3 = new Person("wangwu",30);

        List<Person> persons = Arrays.asList(p1,p2,p3);
        StreamTest streamTest = new StreamTest();
        List<Person> list = streamTest.getPersonsByUsername("lisi", persons);
        System.out.println(list);

        List<Person> personsByAge = streamTest.getPersonsByAge(20, persons);
        System.out.println(personsByAge);

        List<Person> personsByAge2 = streamTest.getPersonsByAge2(20, persons, (age, personList) ->
                persons.stream().filter(person -> person.getAge() > age).collect(Collectors.toList()));
        System.out.println(personsByAge2);
    }
    private List<Person> getPersonsByUsername(String username,List<Person> persons){
        return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }
    private List<Person> getPersonsByAge(int age,List<Person> persons){
        BiFunction<Integer,List<Person>,List<Person>> biFunction = (ageOfPerson,personList)->
            persons.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
        return biFunction.apply(age,persons);
    }
    //实现灵活的调用
    private List<Person> getPersonsByAge2(int age,List<Person> persons,BiFunction<Integer,List<Person>,List<Person>> biFunction){
        return biFunction.apply(age,persons);
    }

}
