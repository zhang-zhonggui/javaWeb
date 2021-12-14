package com.zzg.day03.dao.Impl;

import com.zzg.day03.dao.StuClassDAO;
import com.zzg.day03.entity.Student;
import com.zzg.day03.util.DAOUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class StuClassDAOImpl implements StuClassDAO {
    @Override
    public List<Map<String, Object>> inquireStu() {
        String sql = "select * from class";
        List<Map<String, Object>> request = DAOUtil.request(sql);
        return request;
    }

    @Override
    public int deleteClass(String id) {
        //书写删除的sql语句
        String sql = "delete  from class where id=?";
        //通过DAOTil工具类删除数据库中的内容
        return DAOUtil.update(sql, id);
    }

    @Override
    public int addClass(String name) {
        //书写需要执行的sql语句
        String sql = "insert  into class values (null ,?)";
        //定义i活跃语句执行BAOUtil时的是否成功
        return DAOUtil.update(sql, name);
    }

    @Override
    public List<Map<String, Object>> getClass(String id) {
        //书写查询的语句
        String sql = "select * from class where id =?";
        //通过sql语句与id获取查询的数据
        return DAOUtil.request(sql, id);
    }

    @Override
    public int updateStu(String id,String name) {
        //书写sql语句
        String sql = "update class set grade=? where id=?";
        //执行sql语句并重定向的查询中，重新进行展示
        return DAOUtil.update(sql,name,id);
    }
}
