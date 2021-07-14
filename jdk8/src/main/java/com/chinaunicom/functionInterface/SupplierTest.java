package com.chinaunicom.functionInterface;

import com.chinaunicom.pojo.Person;

import java.util.function.Supplier;

/**
 * @author csw
 * @date
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<Person> supplier = () -> new Person();
        Supplier<Person> supplier1 = Person::new;
        System.out.println(supplier.get().getUsername());
        System.out.println(supplier1.get().getUsername());
    }
}
