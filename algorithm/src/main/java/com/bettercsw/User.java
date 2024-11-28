package com.bettercsw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author csw
 * @date 2021/3/17 10:11
 */
@Data
@EqualsAndHashCode(exclude = {"id", "sex"})
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String sex;
    private int age;
}
