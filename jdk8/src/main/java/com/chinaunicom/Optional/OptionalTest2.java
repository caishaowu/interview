package com.chinaunicom.Optional;

import com.chinaunicom.pojo.Company;
import com.chinaunicom.pojo.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author csw
 * @date
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        Employee employee = new Employee("zhangsan", 24);
        Employee employee2 = new Employee("lisi", 32);
        List<Employee> list = Arrays.asList(employee, employee2);
        Company myCompany = new Company("myCompany", list);
        Optional<Company> optional = Optional.ofNullable(myCompany);
        System.out.println(optional.map(company -> company.getEmployees()).
                orElse(Collections.emptyList()));
    }
}
