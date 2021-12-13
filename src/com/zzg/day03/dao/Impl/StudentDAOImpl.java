package com.zzg.day03.dao.Impl;


import com.zzg.day03.dao.StudentDAO;
import com.zzg.day03.entity.Student;
import com.zzg.day03.util.DAOUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: 与数据库进行交互
 * @DateTime: 2021/11/27 9:58
 */
public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Map<String, Object>> inquireStu() {
        //书写sql语句
        String sql = "select * from student";
        //通过sql与将数据查询出来并展示到stu.jsp中
        return DAOUtil.request(sql);
    }

    @Override
    public int deleteStu(String id) {
        //书写删除的sql语句
        String sql = "delete  from student where id=?";
        //通过DAOTil工具类删除数据库中的内容
        return DAOUtil.update(sql, id);
    }

    @Override
    public int addStu(Student stu) {
        //书写需要执行的sql语句
        String sql = "insert  into student values (null ,?,?,?)";
        //定义i活跃语句执行BAOUtil时的是否成功
        return DAOUtil.update(sql, stu.getName(), stu.getAge(), stu.getAddress());
    }

    @Override
    public List<Map<String, Object>> getStu(String id) {
        //书写查询的语句
        String sql = "select * from student where id =?";
        //通过sql语句与id获取查询的数据
        return DAOUtil.request(sql, id);
    }

    @Override
    public int updateStu(Student stu) {
        //书写sql语句
        String sql = "update student set sname=?,sage=?,saddress=? where id=?";
        //执行sql语句并重定向的查询中，重新进行展示
       return DAOUtil.update(sql, stu.getName(),stu.getAge(),stu.getAddress(),stu.getId());
    }
}
