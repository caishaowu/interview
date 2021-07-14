package com.bettercsw.service.impl;

import com.bettercsw.pojo.Student;
import com.bettercsw.service.StuService;
import com.bettercsw.template.JDBCTemplate;
import com.bettercsw.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author csw
 * @date 2019/11/20 14:12
 */
public class StuServiceImpl implements StuService {

    @Override
    public void save(Student stu) {
        String sql = "INSERT INTO student(sno,sname,ssex) values(?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, stu.getSno());
            ps.setObject(2, stu.getSname());
            ps.setObject(3, stu.getSsex());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, conn, ps);
        }


    }

    @Override
    public void delete(String str) {
        String sql = "DELETE from student where sno = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, str);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, conn, ps);
        }
    }

    @Override
    public void update(Student stu) {

    }

    @Override
    public void get(String str) {

    }

    @Override
    public List<Student> list() {
        String sql = "SELECT * FROM student";
        List<Student> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                Student stu = new Student(sno, sname, ssex);
                result.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, conn, ps);
        }
        return result;
    }

    @Override
    public void save2(Student stu) {
        String sql = "INSERT INTO student(sno,sname,ssex) values(?,?,?)";
        Object[] params = new Object[]{stu.getSno(), stu.getSname(), stu.getSsex()};
        JDBCTemplate.update(sql, params);
    }

    @Override
    public void delete2(String str) {

    }

    @Override
    public void update2(Student stu) {

    }

    @Override
    public void get2(String str) {

    }

    @Override
    public List<Student> list2() {
        String sql = "SELECT * from student";
        return JDBCTemplate.query(sql);
    }
}
