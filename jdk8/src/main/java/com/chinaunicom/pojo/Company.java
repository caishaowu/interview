package com.chinaunicom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author csw
 * @date
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private String name;
    private List<Employee> employees;
}
