package com.bettercsw.service;

import com.bettercsw.pojo.Student;

import java.util.List;

/**
 * @author csw
 * @date 2019/11/20 14:11
 */
public interface StuService {
    /**
     * 重构前
     */

    void save(Student stu);

    void delete(String str);

    void update(Student stu);

    void get(String str);

    List<Student> list();

    /**
     * 初步重构，提取公共操作，存在问题：只支持Student操作
     *
     * @param stu
     */
    void save2(Student stu);

    void delete2(String str);

    void update2(Student stu);

    void get2(String str);

    List<Student> list2();

}
